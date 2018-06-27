package com.javainuse.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.exceptionhandling.ResourceNotFoundException;
import com.javainuse.model.Friend;
import com.javainuse.model.Response;
import com.javainuse.model.ResponseSubscribe;
//import com.javainuse.service.FriendService;
//import com.javainuse.service.FriendServiceException;

@RestController
public class FriendConnectionController {

	@RequestMapping(value = "/API1", method = RequestMethod.POST)
	public ResponseSubscribe FriendConnection(@RequestBody Friend frnd) throws ResourceNotFoundException {
		ResponseSubscribe rs = new ResponseSubscribe();
		String[] friendList = { "andy@example.com", "john@example.com", "steve@example.com", "sandy@example.com" };

		int count = 0;
		for (int i = 0; i < frnd.getFriends().size(); i++) {
			for (int j = 0; j < friendList.length; j++) {
				if ((frnd.getFriends().get(i).toString()).equals(friendList[j])) {
					count++;
					break;
				}
			}
		}

		if (count == 2)
			rs.setSuccess("true");
		else
			throw new ResourceNotFoundException("Emails not found in the friendlist");

		return rs;
	}

	// Second API
	@RequestMapping(value = "/API2", method = RequestMethod.POST)
	public Response getFriendList(@RequestBody Friend frnd) throws ResourceNotFoundException {
		Response rs = new Response();
		String[] friendList = { "andy@example.com", "john@example.com", "steve@example.com" };
		String[] removedNull = null;
		String str[] = new String[3];

		if (frnd.getEmail() == null || frnd.getEmail().equals("")) {
			throw new ResourceNotFoundException("Email cannot be null or empty string");
		}

		for (int i = 0; i < 3; i++) {
			if (!frnd.getEmail().equals(friendList[i])) {
				str[i] = friendList[i];
			}
			removedNull = Arrays.stream(str).filter(value -> value != null && value.length() > 0)
					.toArray(size -> new String[size]);

		}
		if (removedNull.length > 0) {
			rs.setSuccess("true");
			rs.setFriendList(removedNull);
			rs.setCount(removedNull.length);
		} else {
			throw new ResourceNotFoundException("No friendlist present for email id");
		}
		return rs;
	}

	// Third API start
	@RequestMapping(value = "/API3", method = RequestMethod.POST)
	public Response getCommonFriend(@RequestBody Friend frnd) throws ResourceNotFoundException {
		Response rs = new Response();
		String[] friendList = { "andy@example.com", "john@example.com", "common@example.com" };

		int count = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if ((frnd.getFriends().get(i).toString()).equals(friendList[j])) {
					count++;
					break;
				} 
			}
		}

		if (count == 2) {
			String[] commonFrnd = { "common@example.com" };
			rs.setSuccess("true");
			rs.setFriendList(commonFrnd);
			rs.setCount(1);
		} else
			throw new ResourceNotFoundException("Emails not found in the friendlist");
		return rs;
	}

	// Fourth API start
	@RequestMapping(value = "/API4", method = RequestMethod.POST)
	public ResponseSubscribe SubscribeEmail(@RequestBody Friend frnd) throws ResourceNotFoundException {
		ResponseSubscribe rs = new ResponseSubscribe();
		String requestor = frnd.getRequestor();
		String target = frnd.getTarget();
		if (requestor == null) {
			throw new ResourceNotFoundException("requestor not found");
		} else if (target == null) {
			throw new ResourceNotFoundException("target not found");
		} else
			rs.setSuccess("true");

		return rs;
	}

	// Fifth API start
	@RequestMapping(value = "/API5", method = RequestMethod.POST)
	public ResponseSubscribe BlockEmail(@RequestBody Friend frnd) throws ResourceNotFoundException {
		ResponseSubscribe rs = new ResponseSubscribe();

		String[] subscribedList = { "andy@example.com", "john@example.com", "steve@example.com" };
		String[] updateSubscribedList = new String[10];

		List<String> updateSubscribedList1 = new ArrayList<String>();

		String requestor = frnd.getRequestor();
		String target = frnd.getTarget();
		for (int i = 0; i < subscribedList.length; i++) {
			if ((!target.equals(subscribedList[i]))) {
				updateSubscribedList[i] = subscribedList[i];
			}
		}
		if (requestor == null) {
			throw new ResourceNotFoundException("requestor not found");
		} else if (target == null) {
			throw new ResourceNotFoundException("target not found");
		} else
			rs.setSuccess("true");

		return rs;
	}

}
