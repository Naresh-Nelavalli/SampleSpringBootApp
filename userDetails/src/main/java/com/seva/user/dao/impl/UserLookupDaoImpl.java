package com.seva.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.seva.user.dao.UserLookupDao;
import com.seva.user.model.BookKeeper;

public class UserLookupDaoImpl implements UserLookupDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public BookKeeper checkIsNewUser(String phoneNum) {
		
		BookKeeper bk = null;
		try {
			MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
			Query searchUserQuery = new Query(Criteria.where("phoneNum").is(phoneNum));
			bk  = mongoOperation.findOne(searchUserQuery, BookKeeper.class,"book");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()); 
		}
		if(null == bk)
			return null;
		else 
			return bk;
		
	}

	@Override
	public boolean addNewUser(BookKeeper bk) {
		MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;

		try
		{
			mongoOperation.insert(bk,"book");
			return true;
		}
		catch(Exception ex )
		{
			updateUser(bk);
			System.out.println("error::" + ex.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean updateUser(BookKeeper book) {
		MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
		Query searchUserQuery = new Query(Criteria.where("phoneNum").is(book.getPhoneNum()));
		BookKeeper bk  = mongoOperation.findOne(searchUserQuery, BookKeeper.class,"book");
		bk.setOtp(book.getOtp());
		bk.setType(book.getType());
		mongoOperation.save(bk);
		return false;
		
	}

	@Override
	public BookKeeper fetchUserBook(String phoneNum) {
		BookKeeper bk = null;
		try {
			MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
			Query searchUserQuery = new Query(Criteria.where("phoneNum").is(phoneNum));
			bk  = mongoOperation.findOne(searchUserQuery, BookKeeper.class,"book");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()); 
		}
		return bk;
	}

}
