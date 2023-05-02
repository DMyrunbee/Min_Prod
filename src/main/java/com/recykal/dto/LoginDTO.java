package com.recykal.dto;


public class LoginDTO {
	private String email;
	
	private String passward;
	
	
	//private Boolean activeInactiveStatus;
	
	
	public LoginDTO() {
 
	}

 
	 
	public LoginDTO(String email, String passward) {
		super();
		this.email = email;
		this.passward = passward;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassward() {
		return passward;
	}


	public void setPassward(String passward) {
		this.passward = passward;
	}
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", passward=" + passward + "]";
	}

    
	
}
