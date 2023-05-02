package com.recykal.repositary;

import java.util.List;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recykal.dto.OrderDTO;
import com.recykal.dto.ViewByOrderDTO;
import com.recykal.entity.OrdersList;
import com.recykal.entity.User;
@Repository
public interface IOrdersListRepo extends JpaRepository<OrdersList, Long> {
  
  public List<OrdersList> findAll();
 
  
  @Query(value = "SELECT SUM(CASE WHEN order_status = 'Open' THEN 1 ELSE 0 END) AS Open, " +
          "SUM(CASE WHEN order_status = 'Inprogress' THEN 1 ELSE 0 END) AS Inprogress, " +
          "SUM(CASE WHEN order_status = 'Completed' THEN 1 ELSE 0 END) AS Completed " +
          "FROM orderstable", nativeQuery = true)
    public  Map<String,Object>getAllOrderStatus();
  
  
 
  @Modifying
  @Query(value = "UPDATE orders_list SET price = :field1, quantity = :field2 WHERE order_id = :id", nativeQuery = true)
   public void updateFields(@Param("id") Long id, @Param("field1") Double field1, @Param("field2") Float field2);

	
 
  @Query(value = "SELECT COUNT(CASE WHEN order_status = 'Open' THEN 1 ELSE 0 END) AS Open, " +
          "COUNT(CASE WHEN order_status = 'Inprogress' THEN 1 ELSE 0 END) AS Inprogress, " +
          "COUNT(CASE WHEN order_status = 'Completed' THEN 1 ELSE 0 END) AS Completed " +
          "FROM orderstable", nativeQuery = true)
    public  Map<String,Object> findByOrderId(@Param("id") Long orderId);
  
  
  
// @Query(value="SELECT  user_admin_id as userid, COUNT(*) orderscount from orderstable GROUP BY user_admin_id",nativeQuery = true)  
 @Query(value="SELECT u.user_admin_id as userid, u.user_name as name, COUNT(o.order_id) as orderscount\n"
 		+ "FROM user_details u\n"
 		+ "LEFT JOIN orderstable o ON u.user_admin_id = o.user_admin_id\n"
 		+ "GROUP BY u.user_admin_id, u.user_name",nativeQuery = true)
   List<Map<String, Object>> countOrdersByUser();
 
   
 @Query(value = "SELECT ud.user_name as fullName, ol.order_id, ol.price, ol.quantity, ol.order_status, "
         + "ol.open_date_time, ol.inprogress_date_time, ol.completed_date_time "
         + "FROM user_details ud "
         + "INNER JOIN orderstable ol ON ud.user_admin_id = ol.user_admin_id "
         + "WHERE ol.order_id = :orderId", nativeQuery = true)
  public ViewByOrderDTO findByOrderId1(Long orderId);
  
  public List<OrdersList> findByUser(User user);
  

	@Query(value = "SELECT * FROM orderstable as u WHERE TRIM(u.material_name) "
			+ "LIKE %:materialname%", nativeQuery = true)
	public List<OrdersList> findByMaterialNameContaining(@Param("materialname") String materialname);



 @Query(value = "SELECT"
	+ " COUNT(CASE WHEN order_status = 'Open' THEN 1 ELSE 0 END) AS Open, " +
      "COUNT(CASE WHEN order_status = 'Inprogress' THEN 1 ELSE 0 END) AS Inprogress, " +
      "COUNT(CASE WHEN order_status = 'Completed' THEN 1 ELSE 0 END) AS Completed " +
       "FROM orderstable where user_admin_id=:id", nativeQuery = true)
  public  List<OrdersList> findOrderStatussByUserId(@Param("id") Long userId);

	
   }
