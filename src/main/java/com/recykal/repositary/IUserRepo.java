package com.recykal.repositary;

import java.util.List;


import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recykal.dto.ViewByOrderDTO;
import com.recykal.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long>{
	
  User findByEmailAndPassward(String email, String passward) throws Exception;
  
  public Optional<User> findById(Long id);
  public List<User> findByMobileNumber(String mobileNumber);
  public List<User> findAll();
  
  @Query(value = "SELECT COUNT(CASE WHEN user.user_status = true THEN 1 END) AS Active_Count, "
  + "COUNT(CASE WHEN user.user_status = false THEN 1 END) AS Inactive_Count FROM user_details user", nativeQuery = true)
  public Map<String,Long> getAllActiveInactiveCount();
  
  public User findByEmail(String string) throws Exception;
  
  User findById(long userId);
  
		//	  @Query(value = "SELECT * FROM user_details as u WHERE TRIM(u.user_name) = :fullName", nativeQuery = true)
		//	  public List<User> findByFullNameContaining(@Param("fullName") String fullName);

  
 		@Query(value = "SELECT * FROM user_details as u WHERE TRIM(u.user_name) "
  				+ "LIKE %:fullName%", nativeQuery = true)
   		public List<User> findByFullNameContaining(@Param("fullName") String fullName);


// @Query(value="select user_password from user_details where  email=${email} ", nativeQuery=true)
// List<User> findById1(Long id);
  
  
}
 

