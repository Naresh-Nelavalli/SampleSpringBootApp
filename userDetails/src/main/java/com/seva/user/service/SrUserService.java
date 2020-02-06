package com.seva.user.service;

import com.seva.user.exception.UserServiceException;
import com.seva.user.model.SrUser;

public interface SrUserService {
	
	public void createSrUser(SrUser user) throws UserServiceException;
	public void updateSrUser(SrUser user);
	public void deleteSrUser(SrUser user);
	public SrUser getSrUser(SrUser user) throws UserServiceException;

}
