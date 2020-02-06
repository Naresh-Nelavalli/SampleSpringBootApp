package com.seva.user.service;

import com.seva.user.model.PayChannelDetails;
import com.seva.user.model.PayResponse;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;

public interface PaymentService {
	
public PayResponse createPayment(PayChannelDetails pcd) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;
}
