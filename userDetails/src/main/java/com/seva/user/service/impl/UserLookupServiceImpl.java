package com.seva.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.seva.user.dao.UserLookupDao;
import com.seva.user.model.BookKeeper;
import com.seva.user.service.UserLookupService;

public class UserLookupServiceImpl implements UserLookupService {

	@Autowired
	UserLookupDao UserLookupDaoImpl;


	@Override
	public BookKeeper checkIsNewUser(String phoneNum) {

		return UserLookupDaoImpl.checkIsNewUser(phoneNum);
	}

	@Override
	public boolean addNewUser(BookKeeper bk) {
		return UserLookupDaoImpl.addNewUser(bk);
	}
	
	
	@Override
	public boolean updateUser(BookKeeper bk) {
		return UserLookupDaoImpl.updateUser(bk);
	}


}
