package com.seva.user.service;
import com.seva.user.exception.UserServiceException;
import com.seva.user.model.UserDetails;

public interface UserOtpService {
	public long GenerateOtp(String phoneNum);
	public UserDetails VerifyUserOtp(String phoneNum, String otp) throws UserServiceException;
}
