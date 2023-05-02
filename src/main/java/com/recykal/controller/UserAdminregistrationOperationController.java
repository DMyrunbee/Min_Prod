package com.recykal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.recykal.dto.AddUserDTO;
import com.recykal.dto.LoginDTO;
import com.recykal.dto.OrderDTO;
import com.recykal.dto.OrderUserDTO;
import com.recykal.dto.SignUpDTO;
import com.recykal.dto.ViewByOrderDTO;
import com.recykal.entity.OrdersList;
import com.recykal.entity.User;
import com.recykal.repositary.IOrdersListRepo;
import com.recykal.repositary.IUserRepo;
import com.recykal.service.IUserService;

@CrossOrigin("*")
@RestController
public class UserAdminregistrationOperationController {
	
	@Autowired
	private IUserService service;
	  
	  
	
	@Autowired
	private PasswordEncoder encoder;
	


	@Autowired
	private IOrdersListRepo orderRepo;
	
	@Autowired
	private IUserRepo repo;
	
	
	@PostMapping("/UserSignUp")
	public ResponseEntity<User> processUserAdmin(@RequestBody   @Validated SignUpDTO user) throws Exception{
 		User res=service.registorUser(user);
 		return ResponseEntity.ok(res);
	}
	
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
	 
	 
	 @PostMapping("/Login")
	 public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws Exception{
		 
		// if(u.getActiveInactiveStatus()) {
		 User user=service.login(loginDTO);
		 return new ResponseEntity<>(user/*"login succeful with Role:"+user.getDeportment()*/,HttpStatus.OK);
		// }
		//  throw new IllegalArgumentException("Invalid Credential");
	 }
	
	 @PostMapping("/OrderCreation")
	 public ResponseEntity<OrdersList> edit(@RequestBody OrderDTO orderDTO) throws Exception{
 	 OrdersList res=service.registerOrder(orderDTO);
 		return ResponseEntity.ok(res);
 	 }
	 
	 
	 
	 @GetMapping("/ActiveInactiveStatus")
	   public Map<String,Long > getAllActiveInactiveCounts() throws Exception{
 		return  service.getAllActiveInactiveCounts();
	 }
	 
	 
	 
	 //@GetMapping("/AllUsers")
	 @RequestMapping(value="/AllUsers",method=RequestMethod.GET,produces = {"application/json"})
	 @ResponseStatus(HttpStatus.OK)	 
	 public @ResponseBody List<User> getAllCustomers() {
	      return repo.findAll();
	   } 
	 
  
	 
	 
	@PostMapping("/{id}/Enable")
	 public ResponseEntity<?> enable(@PathVariable Long id) throws Exception{
		 service.enable(id);
		 return ResponseEntity.ok().build();
 	 }
	
	
	 
	 @PostMapping("/{id}/Disable")
	 public ResponseEntity<?> disable(@PathVariable Long id) throws Exception{
		 service.disable(id);
		 return ResponseEntity.ok().build();
 	 }
	 
	
	
	
	 
	 
	@GetMapping("/ViewOrderBy/{id}")
	public ResponseEntity<?> getOneOrder(@PathVariable Long id) throws Exception{
		
		return ResponseEntity.ok(service.getOneOrders(id));
		
	}
	
	
	 
	 @PostMapping("/AddUser")
		public ResponseEntity<User> addUser(@RequestBody   @Validated AddUserDTO user) throws Exception{
 			User res=service.addUser(user);
 			return ResponseEntity.ok(res);
		}
	 
	 
	 
	 
	 @GetMapping("/OrdersStatus")
	   public Map<String, Object> getAllOrderStatus() throws Exception{
 		return  service.getAllOrderstatus();
	 }
	 	 
	 
	 
	    @PutMapping("/Edit")
	    public ResponseEntity<OrdersList> updateUser( @RequestBody OrdersList ordersList) {
	        OrdersList existingOrder = orderRepo.findById(ordersList.getOrderId()).orElseThrow(()-> new RuntimeException("OrderNotFound"));	        
	        existingOrder.setPrice(ordersList.getPrice());
	        existingOrder.setQuantity(ordersList.getQuantity());
	       existingOrder.setOrderStatus(ordersList.getOrderStatus());
 	        OrdersList updatedOrdersList = orderRepo.save(existingOrder);
 	        return ResponseEntity.ok(updatedOrdersList);
	    }
	     
	    
      @GetMapping("UserOrdersCount")
      public List<Map<String, Object>> countOrderByUser() {
    	  return service.countOrdersByUser();
      }
     
      @GetMapping("/ViewByOrderId")
      public ResponseEntity<Object> viewOneUserDetails(@RequestParam("orderId") Long orderid){
    	      	 OrdersList ordersList =service.getOrders(orderid);
            	 return ResponseEntity.ok(ordersList);
      }
      
      
      @GetMapping("/Byname/{fullName}")
      public List<User> getUsersByDept(@PathVariable("fullName") String fullName) {
          return service.getUserByFullName(fullName);
      }
      
      
      @GetMapping("/ByMaterialName/{materialname}")
      public List<OrdersList> getOrdersByMaterialname(@PathVariable("materialname") String materialname) {
          return service.getByMaterialName(materialname);
      }
      
      @GetMapping("/AllOrdersByUserId/{userId}")
      public ResponseEntity<List<OrdersList>> viewOrdersById(@PathVariable("userId") Long userId){
    	  return ResponseEntity.ok( service.getOrdersListById(userId));
      }
     
      @GetMapping("/OdersStatusByUser/{userId}")
      public ResponseEntity<Object> viewOrdersStatusById(@PathVariable("userId") Long userId){
    	  return ResponseEntity.ok(service.getOrdersStatusByUserId(userId));
      }
      
      
      @GetMapping("/ViewAll")
	    public ResponseEntity<List<OrderUserDTO>> getOrdersUserInfo() {
	        List<OrderUserDTO> orders = service.getOrdersWithUsersInfo();
	        if (orders.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.ok(orders);
	        }
	    }	 
}
