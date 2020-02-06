package com.seva.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.seva.user.dao.SpUserDetailsDao;
import com.seva.user.exception.SpUserDetailsDaoException;
import com.seva.user.exception.UserCreationFailureException;
import com.seva.user.exception.UserNotFoundException;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SpUserM;
import com.seva.user.model.SpUserN;
import com.seva.user.service.SpUserService;

public class SpUserServiceImpl implements SpUserService 
{
	
	@Autowired
	SpUserDetailsDao spuserdetailsdao;

	@Override
	public void createSpUserC(SpUserC user) throws UserServiceException {
		
		try {
			spuserdetailsdao.createUser(user);
		} catch (SpUserDetailsDaoException e) {
			
			throw new UserCreationFailureException();
		}
	}

	@Override
	public void updateSpUserC(SpUserC user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSpUserC(SpUserC user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SpUserC getSpUserC(SpUserC user) throws UserServiceException {
		 try {
			return spuserdetailsdao.getUser(user);
		} catch (SpUserDetailsDaoException e) {
			throw new UserNotFoundException();
		}
		
	}



	@Override
	public void createSpUserM(SpUserM user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSpUserN(SpUserN user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public SpUserM getSpUserM(SpUserM user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SpUserN getSpUserN(SpUserN user) {
		// TODO Auto-generated method stub
		return null;
	}

}

