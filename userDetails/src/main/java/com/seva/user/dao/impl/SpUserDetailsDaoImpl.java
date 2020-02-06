package com.seva.user.dao.impl;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.seva.user.dao.SpUserDetailsDao;
import com.seva.user.exception.SpUserDetailsDaoException;
import com.seva.user.model.ReqParams;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SpUserM;
import com.seva.user.model.SpUserN;


@Repository
public class SpUserDetailsDaoImpl implements SpUserDetailsDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	Logger log = LoggerFactory.getLogger(SpUserDetailsDaoImpl.class);

	public SpUserDetailsDaoImpl(){

		
	}
	
	// Method to create new user 
	@Override
	public void createUser(SpUserC user) throws SpUserDetailsDaoException{

		MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
		
		try
		{
		mongoOperation.insert(user,"spuserc");
		}
		catch(Exception ex )
		{
			log.error(" error creating SpUser " +user.getPhoneNum() +" " + ex.getMessage());
			throw new SpUserDetailsDaoException();
		}
		
	}

	@Override
	public void updateUser(SpUserC user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(SpUserC user) {
		// TODO Auto-generated method stub
		
	}

	// Fetch a user from DB using Phone number 
	@Override
	public SpUserC getUser(SpUserC user) {
		
	MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
	Query searchUserQuery = new Query(Criteria.where("phoneNum").is(user.getPhoneNum()));
	SpUserC dbuser = mongoOperation.findOne(searchUserQuery, SpUserC.class,"spuserc");
	return dbuser;	
		
	}
	
	
	// Fetch users based on distance. 
	@Override
	public List<SpUserC> fetchNearByUsers(ReqParams reqParams) throws SpUserDetailsDaoException {
	Point point = reqParams.getPoint();
	NearQuery query = NearQuery.near(point.getX(),point.getY()).spherical(true).
			maxDistance(reqParams.getDistance().getValue(),Metrics.MILES);
	GeoResults<SpUserC> dbusers = mongoTemplate.geoNear(query,SpUserC.class);
	List<GeoResult<SpUserC>> dbuserss = dbusers.getContent();
	if(dbuserss.size()==0)
		log.info("No providers with in given distance for zipcode : " + reqParams.getZipcode());
	List<SpUserC> nearProviders = new ArrayList<SpUserC>();
	for(GeoResult<SpUserC> dbuser :dbuserss  )
	{
		SpUserC spuser =  (SpUserC)dbuser.getContent();
		spuser.setDis(dbuser.getDistance());
		nearProviders.add(spuser);
	}
	return nearProviders;
	//return dbusers.getContent().stream().map(GeoResult::getContent).collect(Collectors.toList());	
	}

	
	// Fetch users based on Zipcode !!
	@Override
	public List<SpUserC> fetchSpByZip(ReqParams reqParams) {
		MongoOperations mongoOperation = (MongoOperations) this.mongoTemplate;
		Query searchUserQuery = new Query(Criteria.where("zipcode").is(reqParams.getZipcode()));
		List<SpUserC> spusers = mongoOperation.find(searchUserQuery, SpUserC.class,"spuserc");
		if(spusers.size()==0)
			log.info("No providers with in given distance for zipcode : " + reqParams.getZipcode());
		return spusers;	
	}

	@Override
	public void createUser(SpUserN user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(SpUserM user) {
		// TODO Auto-generated method stub
		
	}



}

