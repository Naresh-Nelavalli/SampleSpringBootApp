package com.seva.user.service;

import com.seva.user.model.BookKeeper;

public interface UserLookupService {
	
	public BookKeeper checkIsNewUser(String phoneNum);
	public boolean addNewUser(BookKeeper bk);
	public boolean updateUser(BookKeeper bk);

}
