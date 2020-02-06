package com.seva.user.dao;

import java.util.List;

import com.seva.user.exception.SpUserDetailsDaoException;
import com.seva.user.model.ReqParams;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SpUserM;
import com.seva.user.model.SpUserN;

public interface SpUserDetailsDao {
	public void createUser(SpUserC user) throws SpUserDetailsDaoException;
	public void createUser(SpUserN user) throws SpUserDetailsDaoException;
	public void createUser(SpUserM user) throws SpUserDetailsDaoException;
	public void updateUser(SpUserC user) throws SpUserDetailsDaoException;
	public void deleteUser(SpUserC user) throws SpUserDetailsDaoException;
	public SpUserC getUser(SpUserC user) throws SpUserDetailsDaoException;
	public List<SpUserC> fetchNearByUsers(ReqParams reqParams) throws SpUserDetailsDaoException ;
	public List<SpUserC> fetchSpByZip(ReqParams reqParams) throws SpUserDetailsDaoException;

}
