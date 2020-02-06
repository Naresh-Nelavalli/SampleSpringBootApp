package com.seva.user.service;


import com.seva.user.exception.UserServiceException;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SpUserM;
import com.seva.user.model.SpUserN;

public interface SpUserService {
	
	public void createSpUserC(SpUserC user) throws UserServiceException;
	public void createSpUserM(SpUserM user);
	public void createSpUserN(SpUserN user);
	public void updateSpUserC(SpUserC user);
	public void deleteSpUserC(SpUserC user);
	public SpUserC getSpUserC(SpUserC user) throws UserServiceException;
	public SpUserM getSpUserM(SpUserM user);
	public SpUserN getSpUserN(SpUserN user);

}