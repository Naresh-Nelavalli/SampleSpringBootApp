package com.seva.user.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seva.user.dao.impl.SpUserDetailsDaoImpl;
import com.seva.user.model.PayChannelDetails;
import com.seva.user.model.PayResponse;
import com.seva.user.service.PaymentService;


import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;


public class StripePaymentImpl implements PaymentService {

	Logger log = LoggerFactory.getLogger(SpUserDetailsDaoImpl.class);
	@Override
	public PayResponse createPayment(PayChannelDetails pcd) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {
		
		
		 log.warn("Charging: " + pcd.getEmail() + " For: " + pcd.getAmount());
		 PayResponse pr = new PayResponse();
		    try {

		      // See your keys here: https://dashboard.stripe.com/account/apikeys
		      Stripe.apiKey = "";// get from config 

		      // Create a charge: this will charge the user's card
		      Map<String, Object> chargeParams = new HashMap<String, Object>();
		      // Amount in cents, multiple by 100, and send it as integer for API.
		      chargeParams.put("amount", pcd.getAmount().multiply(new BigDecimal("100")).intValueExact());
		      chargeParams.put("currency", "usd");
		      chargeParams.put("source", pcd.getSource());
		      chargeParams.put("description", pcd.getDesc());
		      chargeParams.put("receipt_email", pcd.getEmail());
		      chargeParams.put("statement_descriptor", "GRIC Payment");

		      Charge charge = Charge.create(chargeParams);

		      String chargeIdAndReceiptNumber = charge.getId() + "," + charge.getReceiptNumber();
		      
		      pr.setErrorCode(0);
		      pr.setErrorMessage("success");
		      pr.setTransactionStatus("success");
		      pr.setReceipt(chargeIdAndReceiptNumber);

		      //return chargeIdAndReceiptNumber;
		    } catch (Exception e) {
		      // The card has been declined
		      log.error("Charge failed for: " + pcd.getEmail() + " For: " + pcd.getAmount());
		      pr.setErrorCode(8);
		      pr.setErrorMessage(e.getMessage());
		      pr.setTransactionStatus("Failed because of exception");
		    }
		    
		    
		return null;
	}
	

}
