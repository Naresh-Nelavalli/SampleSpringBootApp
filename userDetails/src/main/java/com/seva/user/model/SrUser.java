package com.seva.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "srusers")
public class SrUser extends User
{
	@Id
	private String  id;
	
}

