package com.javainuse.model;

public class Response {
	public String success;
	public String[] friendList;
	public int count;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String[] getFriendList() {
		return friendList;
	}
	public void setFriendList(String[] friendList) {
		this.friendList = friendList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	

}