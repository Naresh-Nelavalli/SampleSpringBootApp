package com.seva.user.controller;

import java.util.List;

//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.BookKeeper;
import com.seva.user.model.ReqParams;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SrUser;
import com.seva.user.model.UserDetails;
import com.seva.user.service.SpUserService;
import com.seva.user.service.SrUserService;
import com.seva.user.service.serviceProviderService;
import com.seva.user.service.UserLookupService;
import com.seva.user.service.UserOtpService;
//import static org.junit.Assert.assertEquals;

@RestController
@CrossOrigin
public class userController {
	@Autowired
	SrUserService sruserserviceimpl;
	@Autowired
	SpUserService spuserserviceimpl;
	@Autowired
	serviceProviderService serviceproviderservice;	
	@Autowired
	UserLookupService userlookupservice;	
	@Autowired
	UserOtpService userotpservice;
	
	
	//ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	//Validator validator = factory.getValidator();
	
	public static final Logger log = LoggerFactory.getLogger(userController.class);
	@RequestMapping(method = RequestMethod.POST,value ="/creteSrUser")
	public void creteNewsrUser(@RequestBody SrUser newUser) 
	{
		
		//Set<ConstraintViolation<SrUser>> constraintViolations = validator.validate(newUser);
		//assertEquals(1, constraintViolations.size());
		try {
			sruserserviceimpl.createSrUser(newUser);
		} catch (UserServiceException e) {
			
			log.error(e.getMessage());
		}
		BookKeeper bk = new BookKeeper();
		bk.setPhoneNum(newUser.getPhoneNum());
		bk.setType("RQ");
		String otpValue = String.valueOf(userotpservice.GenerateOtp(newUser.getPhoneNum()));
		bk.setOtp(otpValue);	
		userlookupservice.addNewUser(bk);
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/creteSpUserC")
	public void creteNewSpUserC(@RequestBody SpUserC newUser) 
	{
		try {
			spuserserviceimpl.createSpUserC(newUser);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		BookKeeper bk = new BookKeeper();
		bk.setPhoneNum(newUser.getPhoneNum());
		bk.setType("PC");
		String otpValue = String.valueOf(userotpservice.GenerateOtp("3158008941"));
		bk.setOtp(otpValue);
		userlookupservice.addNewUser(bk);
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/getSpUser/{mobileNum}", produces="application/json")
	public SpUserC getSpUserC(@PathVariable String mobileNum ) 
	{
		SpUserC user = new SpUserC();
		user.setPhoneNum(mobileNum);
		SpUserC dbuser = null;
		try {
			dbuser = spuserserviceimpl.getSpUserC(user);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

		return dbuser;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/getSrUser/{mobileNum}", produces="application/json")
	public SrUser getSrUser(@PathVariable String mobileNum) 
	{
		SrUser user = new SrUser();
		user.setPhoneNum(mobileNum);
		SrUser dbuser = null;
		try {
			dbuser = sruserserviceimpl.getSrUser(user);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

		return dbuser;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/fetchServiceProviders/{mobileNum}", produces="application/json")
	public List<SpUserC> fetchServiceProviders(@PathVariable String mobileNum,
			 @RequestParam(value = "distance",defaultValue = "10") double distance) 
	{
		ReqParams rp = new ReqParams(mobileNum,new Distance(distance));
		rp.setMobileNum(mobileNum);
		List<SpUserC> spusers = null;
		try {
			spusers = serviceproviderservice.fetchNearbyProviders(rp);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		if (spusers == null)
			log.info("FetchServiceProvier , Empty, no users found");
		return spusers;
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value ="/fetchSpByZip/{zipcode}", produces="application/json")
	public List<SpUserC> fetchSpZipcode(@PathVariable String zipcode,
			 @RequestParam(value = "distance",defaultValue = "10") double distance) 
	{
		ReqParams rp = new ReqParams(zipcode,new Distance(distance));
		List<SpUserC> spusers = null;
		try {
			spusers = serviceproviderservice.fetchSpByZip(rp);
		} catch (UserServiceException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		return spusers;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/checkncreate/{phoneNum}", produces="application/json")
	public boolean checkIsNewUser(@PathVariable String phoneNum) 
	{
		
		BookKeeper book = userlookupservice.checkIsNewUser(phoneNum);
		boolean isNewUser = false;
		if (book == null )
		{
			BookKeeper bk = new BookKeeper();
			bk.setPhoneNum(phoneNum);
			//Generate OTP
			String otpValue = String.valueOf(userotpservice.GenerateOtp(phoneNum));
			bk.setOtp(otpValue);
			userlookupservice.addNewUser(bk);
			log.info("Checkncreate, Created new user !!!");
			isNewUser = true;
		}else
		{
			//Generate OTP and 
			String otpValue = String.valueOf(userotpservice.GenerateOtp(phoneNum));
			book.setOtp(otpValue);
			log.info("Checkncreate, Existing user, updated new OTP !!");
			userlookupservice.updateUser(book);
		}
		return isNewUser;
	}
	
	@RequestMapping(method = RequestMethod.GET,value ="/verifyOtp/{phoneNum}", produces="application/json")
	public UserDetails verifyOtp(@PathVariable String phoneNum,
			@RequestParam(value = "otp",defaultValue = "999999") String otp ) throws UserServiceException 
	{		
		 
				UserDetails ud = 	userotpservice.VerifyUserOtp(phoneNum, otp);
				return ud;
	}
	

}
