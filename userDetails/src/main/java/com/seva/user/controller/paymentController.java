package com.seva.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seva.user.model.PayChannelDetails;
import com.seva.user.model.PayResponse;
public class paymentController {
	
	
	@RequestMapping(method = RequestMethod.POST,value ="/createPayment")
	public PayResponse createPayment(@RequestBody PayChannelDetails newpay) 
	{
		
		return null;
		
	}

}
