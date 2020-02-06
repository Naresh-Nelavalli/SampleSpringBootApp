package com.seva.user.service;

import java.util.List;

import com.seva.user.exception.UserServiceException;
import com.seva.user.model.ReqParams;
import com.seva.user.model.SpUserC;



public interface serviceProviderService {

	public List<SpUserC> fetchNearbyProviders(ReqParams reqParams) throws UserServiceException;
	public List<SpUserC> fetchSpByZip(ReqParams reqParams) throws UserServiceException;

}