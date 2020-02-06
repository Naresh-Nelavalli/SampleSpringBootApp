package com.seva.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.mapping.Document;
// Nanny provider 
@Document(collection = "spusers")
public class SpUserN extends User
{
	@Id
	private String  id;
	private double wWage;
	private double mWage;
	private double dWage;
	private String svcType;
	private String sex;
	
	private Distance dis;

	public Distance getDis() {
		return dis;
	}

	public void setDis(Distance distance) {
		this.dis = distance;
	}

	
	public double getwWage() {
		return wWage;
	}
	public void setwWage(double wWage) {
		this.wWage = wWage;
	}
	public double getmWage() {
		return mWage;
	}
	public void setmWage(double mWage) {
		this.mWage = mWage;
	}
	public double getdWage() {
		return dWage;
	}
	public void setdWage(double dWage) {
		this.dWage = dWage;
	}
	
	public String getSvcType() {
		return svcType;
	}
	public void setSvcType(String svcType) {
		this.svcType = svcType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


}

