package com.seva.user.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringMongoConfig {
	
	@Value( "${mongouser.uri}" )
	private String mongoUri;
	

    public @Bean MongoClient mongoClient() {
    	//System.out.println(mongoUri);
    	MongoClientURI uri = new MongoClientURI(mongoUri);
        return new MongoClient(uri);
    }

    @DependsOn (value = { "mongoClient"})
    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongoClient(), "userdetails");
    }

    @DependsOn (value = { "mongoDbFactory"})
    public @Bean MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }

}
