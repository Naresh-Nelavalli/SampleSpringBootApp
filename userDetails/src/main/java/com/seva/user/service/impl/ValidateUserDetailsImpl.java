package com.seva.user.service.impl;

import com.seva.user.model.SpUserC;
import com.seva.user.model.SrUser;

public class ValidateUserDetailsImpl 
{
	
	public boolean validateSrUser(SrUser srUser)
	{
		if(srUser.getPhoneNum() == null)
			return false;
		if(srUser.getEmail() == null)
			return false;
		if(srUser.getAge() == null)
			return false;
		if(srUser.getImagesrc() == null)
			return false;
		if(srUser.getlName() == null)
			return false;
		return true;
		
	}
	public boolean validateSpUser(SpUserC spUser)
	{
		if(spUser.getPhoneNum() == null)
			return false;
		if(spUser.getEmail() == null)
			return false;
		if(spUser.getAge() == null)
			return false;
		if(spUser.getImagesrc() == null)
			return false;
		if(spUser.getlName() == null)
			return false;
		return true;
		
	}

}
