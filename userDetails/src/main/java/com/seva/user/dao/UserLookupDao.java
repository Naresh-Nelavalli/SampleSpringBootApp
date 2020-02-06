package com.seva.user.dao;

import com.seva.user.model.BookKeeper;

public interface UserLookupDao {

	public BookKeeper checkIsNewUser(String phoneNum);
	public boolean addNewUser(BookKeeper book);
	public BookKeeper fetchUserBook(String phoneNum);
	boolean updateUser(BookKeeper book);
}
