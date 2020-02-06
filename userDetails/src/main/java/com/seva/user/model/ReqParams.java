package com.seva.user.model;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public class ReqParams {

	private String mobileNum;
	private Distance distance;
	private Point point;
	private String zipcode;
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public  ReqParams(String zipcode)
	{
		this.zipcode = zipcode;
	}
	
	public  ReqParams(String mobileNum, Distance distance)
	{
		this.mobileNum = mobileNum;
		this.distance = distance;
	}
	
	public  ReqParams(Point point, Distance distance)
	{
		this.point = point;
		this.distance = distance;
	}
	
	public  ReqParams()
	{
		
	}
	
}
