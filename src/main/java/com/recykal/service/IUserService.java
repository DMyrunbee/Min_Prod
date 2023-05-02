package com.recykal.service;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.emitter.EmitterException;

import com.recykal.dto.AddUserDTO;
import com.recykal.dto.LoginDTO;
import com.recykal.dto.OrderDTO;
import com.recykal.dto.OrderUserDTO;
import com.recykal.dto.SignUpDTO;
import com.recykal.dto.ViewByOrderDTO;
import com.recykal.entity.OrdersList;
import com.recykal.entity.User;

import jakarta.persistence.criteria.Order;



public interface IUserService{
	 public User registorUser(SignUpDTO signupdto) throws Exception;
   	 public OrdersList registerOrder(OrderDTO orderDTO) throws Exception;
	 public  User login(LoginDTO user) throws Exception;
	 public void enable(Long id) throws Exception;
	 public void disable(Long id) throws Exception;
	 public List<User> getAllCustomers();
	 public Map<String, Long> getAllActiveInactiveCounts() throws Exception;
     public List<OrderUserDTO> getOrdersWithUsersInfo() ;
	 public User addUser(AddUserDTO adduserdto) throws Exception;
 	 public Map<String,Object> getAllOrderstatus() throws Exception;
     public OrdersList updateOrderList(OrdersList list) throws Exception;
  	 public Map<String,Object> getOneOrders(Long id) throws Exception;
 	 public List<Map<String, Object>> countOrdersByUser();
 	 public ViewByOrderDTO findByOrderId12(Long orderId);
 	 public OrdersList getOrders(Long orderId);
  	 public List<User> getUserByFullName(String name);
  	 public List<OrdersList> getOrdersListById(Long userId) ;
	 public List<OrdersList> getByMaterialName(String materialname);

	 public Object getOrdersStatusByUserId(Long userId);

}
