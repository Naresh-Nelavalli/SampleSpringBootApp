package com.seva.user.dao;

import com.seva.user.exception.SrUserDetailsDaoException;
import com.seva.user.model.SrUser;

public interface SrUserDetailsDao {
	public void createUser(SrUser user) throws SrUserDetailsDaoException;
	public void updateUser(SrUser user);
	public void deleteUser(SrUser user);
	public SrUser getUser(SrUser user) throws SrUserDetailsDaoException;

}
