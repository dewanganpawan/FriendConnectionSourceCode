package com.javainuse.model;

import java.util.List;

public class Friend {
	public String email;
	public String status;
	public List name;
	public List friends;
	public String requestor;
	public String target;

	
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List getName() {
		return name;
	}
	public void setName(List name) {
		this.name = name;
	}
	public List getFriends() {
		return friends;
	}
	public void setFriends(List friends) {
		this.friends = friends;
	}
	
	
	

	

}