package com.seva.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.seva.user.dao.SrUserDetailsDao;
import com.seva.user.exception.SrUserDetailsDaoException;
import com.seva.user.exception.UserCreationFailureException;
import com.seva.user.exception.UserNotFoundException;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.SrUser;
import com.seva.user.service.SrUserService;

public class SrUserServiceImpl implements SrUserService 
{
	
	@Autowired
	SrUserDetailsDao sruserdetailsdao;

	@Override
	public void createSrUser(SrUser user) throws UserServiceException {
		
		try {
			sruserdetailsdao.createUser(user);
		} catch (SrUserDetailsDaoException e) {
			
			throw new UserCreationFailureException();
		}
	}

	@Override
	public void updateSrUser(SrUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSrUser(SrUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SrUser getSrUser(SrUser user) throws UserServiceException {
		 try {
			return sruserdetailsdao.getUser(user);
		} catch (SrUserDetailsDaoException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException();
		}
		
	}

}

