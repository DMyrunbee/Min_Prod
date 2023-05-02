package com.recykal.service;

import java.security.MessageDigest;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recykal.dto.AddUserDTO;
import com.recykal.dto.LoginDTO;
import com.recykal.dto.OrderDTO;
import com.recykal.dto.OrderUpdateDTO;
import com.recykal.dto.OrderUserDTO;
import com.recykal.dto.SignUpDTO;
import com.recykal.dto.ViewByOrderDTO;
import com.recykal.entity.OrdersList;
import com.recykal.entity.User;
import com.recykal.repositary.IOrdersListRepo;
import com.recykal.repositary.IUserRepo;


@Service
public class UserMangServiceImpl  implements IUserService{
	
	@Autowired
	private IUserRepo repo;
	
	@Autowired
	private IOrdersListRepo orderRepo;
	
	 
	@Autowired 
	private PasswordEncoder encoder;
 

	@Override
	public List<User> getAllCustomers() {
		return repo.findAll();
	}


	@Override
	public User registorUser(SignUpDTO signdto) throws Exception {		
		User user = new User();
		 
		user.setFullName(signdto.getFullName());
		user.setMobileNumber(signdto.getMobileNumber());
		user.setEmail(signdto.getEmail());
		user.setActiveInactiveStatus(true);
		user.setPassward(encoder.encode(signdto.getPassward()));
		user.setDeportment("User");
		user.setDate(ZonedDateTime.now());
		
		User u=repo.save(user);
		return u ;
	
	}

	@Override
	public User login(LoginDTO loginDTO) throws Exception {
	String p=	loginDTO.getPassward();
	User u=repo.findByEmail(loginDTO.getEmail());
	String y=u.getPassward();
	 	Boolean b=encoder.matches(p, y);
	 
		if(b==false) {
			 throw new IllegalArgumentException("YOU ENTERED INVALID EMAIL OR PASSWORD");
		}	
 		if(u.getActiveInactiveStatus()) {
		return u;
		}
		throw new IllegalArgumentException("Invalid credentials:");
	}
	 
	 	
	@Override
	public OrdersList registerOrder(OrderDTO orderDTO) throws Exception {		
		Optional<User>  user =repo.findById(orderDTO.getUserId());
 		
		OrdersList ordersList = new OrdersList();	 
  		ordersList.setMaterialName(orderDTO.getMaterialName());
		ordersList.setPrice(orderDTO.getPrice());
		ordersList.setQuantity(orderDTO.getQuantity());
		ordersList.setOpenDate(ZonedDateTime.now()); 
		ordersList.setOrderStatus("Open");
		ordersList.setUser(user.get());
		
		
		OrdersList order=orderRepo.save(ordersList);
		return order;
	}
	
		@Override
		 public Map<String,Long> getAllActiveInactiveCounts() throws Exception{
				return  repo.getAllActiveInactiveCount();
		}
	
	@Override
	public void enable(Long id) throws Exception {
		 Optional<User> ouser=repo.findById(id);
		 if(ouser.isPresent()) {
			 User user=ouser.get();
			 user.setActiveInactiveStatus(true);
			 repo.save(user);
		 }	
	}
	
	
	@Override
	 public void disable(Long id)throws Exception{
		 Optional<User> ouser=repo.findById(id);
		 if(ouser.isPresent()) {
		 User user=ouser.get();
		 user.setActiveInactiveStatus(false);
		 repo.save(user);
		 }
	 }
		  
	
        @Override		
        public List<OrderUserDTO> getOrdersWithUsersInfo() {
        List<OrdersList> orders = orderRepo.findAll();
        List<OrderUserDTO> result = new ArrayList<>();
         for (OrdersList order : orders) {
            User user = repo.findById(order.getOrderId()).orElse(null);
            if (user != null) {
                 result.add(new OrderUserDTO(order.getMaterialName(),order.getOrderId(), order.getOpenDate(), order.getPrice(),order.getMaterialName() ,order.getOrderStatus() ));
            }
        }
        
        return result;
    }
       
       
	@Override
	public User addUser(AddUserDTO adduserdto) throws Exception {
		User user = new User();	
		user.setFullName(adduserdto.getFullName());
		user.setMobileNumber(adduserdto.getMobileNumber());
		user.setEmail(adduserdto.getEmail());
		user.setActiveInactiveStatus(true);
		user.setPassward(UserMangServiceImpl.encode(adduserdto.getPassward()));
		user.setDeportment("User");
		user.setDate(ZonedDateTime.now());
				
		User u=repo.save(user);
		return u ;
	
	}

	 
	@Override
	public Map<String, Object> getAllOrderstatus() throws Exception {
		 
		return orderRepo.getAllOrderStatus();
	}
	
	
	@Override
	public Map<String,Object> getOneOrders(Long id) throws Exception {
		
		
		return orderRepo.findByOrderId(id);
		
	}
	
	 

	@Override
	public OrdersList updateOrderList(OrdersList list) throws Exception {
 		OrdersList existingOrder=orderRepo.getById(list.getOrderId());
		existingOrder.setPrice(list.getPrice());
		existingOrder.setQuantity(list.getQuantity());
		return orderRepo.save(existingOrder);
	}
	
 
	
	 public static String encode(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            byte[] hash = md.digest(password.getBytes());
	            return Base64.getEncoder().encodeToString(hash);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
 

	@Override
	public List<Map<String, Object>> countOrdersByUser() {
 		return orderRepo.countOrdersByUser();
	}
 
	

	 public ViewByOrderDTO findByOrderId12(Long orderId) {
	        return orderRepo.findByOrderId1(orderId);
	    }
 

	@Override
	public OrdersList getOrders(Long orderId) {
	Optional<OrdersList> order= orderRepo.findById(orderId);
		return order.get() ;
	}
	
	@Override
	public List<User> getUserByFullName(String fullName) {
        String name1 = fullName.trim();
        return repo.findByFullNameContaining(name1);
    }

	@Override
	public List<OrdersList> getOrdersListById(Long userId) {
		User user=new User();
		user.setId(userId);
		return 	 orderRepo.findByUser(user);
			 
	}

	 @Override
	public List<OrdersList> getByMaterialName(String materialname) {
        String name1 = materialname.trim();
        return orderRepo.findByMaterialNameContaining(name1);
    }

	 
	public List<OrdersList> getOrdersStatusByUserId(Long userId) {
		User user=new User();
		user.setId(userId);
		
		return orderRepo.findOrderStatussByUserId(user.getId());
		
	}
	
	
}
