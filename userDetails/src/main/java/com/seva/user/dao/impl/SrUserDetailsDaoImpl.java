package com.seva.user.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.seva.user.dao.SrUserDetailsDao;
import com.seva.user.exception.SrUserDetailsDaoException;
import com.seva.user.model.SrUser;

@Repository
public class SrUserDetailsDaoImpl implements SrUserDetailsDao {

	@Autowired
	MongoTemplate mongoTemplate;

	Logger log = LoggerFactory.getLogger(SrUserDetailsDaoImpl.class);
	
	public SrUserDetailsDaoImpl(){



	}
	@Override
	public void createUser(SrUser user) throws SrUserDetailsDaoException {
		MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;

		try
		{
			mongoOperation.insert(user,"srusers");
		}
		catch(Exception ex )
		{
			log.error(" error creating SpUser " +user.getPhoneNum() +" " + ex.getMessage());
			throw new SrUserDetailsDaoException();
		}

	}

	@Override
	public void updateUser(SrUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(SrUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public SrUser getUser(SrUser user) throws SrUserDetailsDaoException {
		SrUser dbuser = null;
		try {
			MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
			Query searchUserQuery = new Query(Criteria.where("phoneNum").is(user.getPhoneNum()));
			dbuser = mongoOperation.findOne(searchUserQuery, SrUser.class,"srusers");
		}
		catch(Exception ex)
		{
			log.error(" error fetching Sruser  " +user.getPhoneNum() +" " + ex.getMessage());
			throw new SrUserDetailsDaoException();
		}
		return dbuser;
	}

}
