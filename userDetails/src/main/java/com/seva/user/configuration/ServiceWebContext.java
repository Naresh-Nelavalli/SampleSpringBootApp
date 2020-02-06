package com.seva.user.configuration;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.seva.user.dao.SrUserDetailsDao;
import com.seva.user.dao.UserLookupDao;
import com.seva.user.dao.SpUserDetailsDao;
import com.seva.user.dao.impl.SrUserDetailsDaoImpl;
import com.seva.user.dao.impl.UserLookupDaoImpl;
import com.seva.user.dao.impl.SpUserDetailsDaoImpl;
import com.seva.user.service.SpUserService;
import com.seva.user.service.SrUserService;
import com.seva.user.service.UserLookupService;
import com.seva.user.service.UserOtpService;
import com.seva.user.service.serviceProviderService;
import com.seva.user.service.impl.SpUserServiceImpl;
import com.seva.user.service.impl.SrUserServiceImpl;
import com.seva.user.service.impl.UserLookupServiceImpl;
import com.seva.user.service.impl.UserOtpServiceImpl;
import com.seva.user.service.impl.serviceProviderServiceImpl;

@Configuration

public class ServiceWebContext implements ApplicationContextAware{
	
	//private static ApplicationContext context  = null;
	
	public String configPath;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//context = applicationContext;
		
	}
	
	
	@Bean(name = "sruserdetailsdao")
	@Scope("singleton")
	public SrUserDetailsDao getSrUserDao()
	{
				
		SrUserDetailsDao sruserdetailsdao = new SrUserDetailsDaoImpl();
		return sruserdetailsdao;
	}
	
	@Bean(name = "spuserdetailsdao")
	@Scope("singleton")
	public SpUserDetailsDao getSpUserDao()
	{
				
		SpUserDetailsDao spuserdetailsdao = new SpUserDetailsDaoImpl();
		return spuserdetailsdao;
	}
	
	@Bean(name = "userlookupdao")
	@Scope("singleton")
	public UserLookupDao getUserLookUpDao()
	{
				
		UserLookupDao userlookupdao = new UserLookupDaoImpl();
		return userlookupdao;
	}
	
	@Bean(name = "userotpservice")
	@Scope("singleton")
	public UserOtpService getUserOtpService()
	{
				
		UserOtpService userotpservice = new UserOtpServiceImpl();
		return userotpservice;
	}
	
	
	
	@Bean(name = "sruserservice")
	@Scope("singleton")
	public SrUserService getSrUserService()
	{
				
		SrUserService sruserservice = new SrUserServiceImpl();
		return sruserservice;
	}
	
	@Bean(name = "spuserservice")
	@Scope("singleton")
	public SpUserService getSpUserService()
	{
				
		SpUserService spuserservice = new SpUserServiceImpl();
		return spuserservice;
	}
	
	
	@Bean(name = "serviceproviderservice")
	@Scope("singleton")
	public serviceProviderService getServiceProviderService()
	{
				
		serviceProviderService spuserservice = new serviceProviderServiceImpl();
		return spuserservice;
	}
	
	@Bean(name = "userlookupservice")
	@Scope("singleton")
	public UserLookupService getUserLookupService()
	{
				
		UserLookupService userlookupservice = new UserLookupServiceImpl();
		return userlookupservice;
	}
	

}

