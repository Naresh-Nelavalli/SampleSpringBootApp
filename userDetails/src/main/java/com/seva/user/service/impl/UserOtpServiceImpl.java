package com.seva.user.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.seva.user.dao.UserLookupDao;
import com.seva.user.dao.impl.SrUserDetailsDaoImpl;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.BookKeeper;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SpUserM;
import com.seva.user.model.SpUserN;
import com.seva.user.model.SrUser;
import com.seva.user.model.UserDetails;
import com.seva.user.service.SpUserService;
import com.seva.user.service.SrUserService;
import com.seva.user.service.UserOtpService;

public class UserOtpServiceImpl implements UserOtpService {

	Logger log = LoggerFactory.getLogger(SrUserDetailsDaoImpl.class);

	@Autowired
	UserLookupDao UserLookupDaoImpl;

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	SrUserService sruserserviceimpl;
	@Autowired
	SpUserService spuserserviceimpl;

	@Override
	public long  GenerateOtp(String phoneNum) {
		// TODO Auto-generated method stub
		Random generator = new Random(); 
		long num = 100000 + generator.nextInt(900000);
		return num;
		
	}

	@Override
	public UserDetails VerifyUserOtp(String phoneNum, String otp) throws UserServiceException {
		BookKeeper bk = UserLookupDaoImpl.fetchUserBook(phoneNum);
		if(null == bk)
		{
			return new UserDetails();
		}
		UserDetails output = new UserDetails();
		if(validateOtp(bk.getOtp(),otp))
		{
			output.setVerifiedStatus(true);
			if(null != bk.getType())
			{
			switch(bk.getType())
			{
				case "PM":
				{
					SpUserM user = new SpUserM();
					user.setPhoneNum(phoneNum);
					output.setProvider(true);
					output.setSpuserm(spuserserviceimpl.getSpUserM(user));
					break;
				}
				case "PN":
				{
					SpUserN user = new SpUserN();
					user.setPhoneNum(phoneNum);
					output.setProvider(true);
					output.setSpusern(spuserserviceimpl.getSpUserN(user));
					break;
					
				}
				case "PC":
				{
					SpUserC user = new SpUserC();
					user.setPhoneNum(phoneNum);
					output.setProvider(true);
					output.setSpuserc(spuserserviceimpl.getSpUserC(user));
					break;
				}
				case "RQ":
				{
					SrUser user = new SrUser();
					user.setPhoneNum(phoneNum);
					output.setProvider(false);
					output.setSruser((sruserserviceimpl.getSrUser(user)));
					break;
				}
				default:
				{
					log.error("Invalid userType !! Not PM/PN/PC/RQ");
					return output;
				}
			}}
		}
		else
		{
			output.setVerifiedStatus(false);
		}
		return output;
	}

	public boolean validateOtp(String gen, String rec) {
		return gen.equals(rec);		
	}

}
