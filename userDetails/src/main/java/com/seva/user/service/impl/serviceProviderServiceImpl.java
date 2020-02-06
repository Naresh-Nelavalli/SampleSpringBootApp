package com.seva.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import com.seva.user.dao.SpUserDetailsDao;
import com.seva.user.dao.SrUserDetailsDao;
import com.seva.user.exception.SpUserDetailsDaoException;
import com.seva.user.exception.SrUserDetailsDaoException;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.ReqParams;
import com.seva.user.model.SpUserC;
import com.seva.user.model.SrUser;
import com.seva.user.service.serviceProviderService;

public class serviceProviderServiceImpl implements serviceProviderService {

	@Autowired
	SpUserDetailsDao spuserdetailsdao;

	@Autowired
	SrUserDetailsDao sruserdetailsdao;

	@Override
//	@HystrixCommand(fallbackMethod = "fetchDefaultProviders",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000")})
	public List<SpUserC> fetchNearbyProviders(ReqParams reqParams) throws UserServiceException {
		// check for non null values 
		Point defaultPoint =null;
		SrUser sruser = new SrUser();
		if(reqParams.getPoint()== null )
		{
			sruser.setPhoneNum(reqParams.getMobileNum());
			SrUser sruserOut = sruserdetailsdao.getUser(sruser);
			if (sruserOut != null)
			{
				defaultPoint = sruserOut.getAddress().getLoc();
			}
			else
			{
				return null;
			}
			defaultPoint = sruserOut.getAddress().getLoc();
			reqParams.setPoint(defaultPoint);
		}
		List<SpUserC> spUsersList = spuserdetailsdao.fetchNearByUsers(reqParams);
		return spUsersList;
	}

	@Override
	public List<SpUserC> fetchSpByZip(ReqParams reqParams) throws UserServiceException {

		List<SpUserC> spUsersList = spuserdetailsdao.fetchSpByZip(reqParams);
		return spUsersList;
	}
	
	public List<SpUserC> fetchDefaultProviders(ReqParams reqParams) throws UserServiceException {
		Distance d = new Distance(200);
		reqParams.setZipcode("60090");
		reqParams.setDistance(d);
		List<SpUserC> spUsersList = spuserdetailsdao.fetchSpByZip(reqParams);
		return spUsersList;
	}
	
	public List<SpUserC> checkIsNewUser(ReqParams reqParams) throws UserServiceException {

		List<SpUserC> spUsersList = spuserdetailsdao.fetchSpByZip(reqParams);
		return spUsersList;
	}

}
