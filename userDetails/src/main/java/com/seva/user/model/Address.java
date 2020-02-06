package com.seva.user.model;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Address
{  

	public Address(String Street, String City, String State, String Zip,Point loc)
	{  
		this.street = Street;
		this.city = City;
		this.state = State;
		this.zip = Zip;
		// check location size and check for null. If so retrun lcationException
		// that should be handled in the mobile application, resend the request
		// with proper value.
		this.loc = loc;

	}   
	
	public Address()
	{  
		
	}  
	
	public Address(Point point)
	{  
		this.loc = point;
	}   



	public String format()
	{  
		return street + "\n"
				+ city + ", " + state + " " + zip;
	}
	@Field
	private String street;
	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

	private String city;
	private String state;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String zip;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	private Point loc;
	public Point getLoc() {
		return loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}
}

