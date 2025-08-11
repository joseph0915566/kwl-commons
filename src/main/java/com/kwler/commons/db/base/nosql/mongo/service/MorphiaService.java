package com.kwler.commons.db.base.nosql.mongo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.glassfish.hk2.api.PreDestroy;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kwler.commons.db.base.nosql.mongo.model.BaseMongoObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class MorphiaService implements PreDestroy {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MorphiaService.class);
	
	private final Datastore datastore;
	private final String databaseName;
	private final MongoClient mongoClient;
	private final Morphia morphia;

	@Inject
	public MorphiaService(Properties properties){
		
		String dbHost = properties.getProperty("db.host");
		if(dbHost == null) throw new RuntimeException("Property db.host not found, can't resolve DB host");
		else LOGGER.info("DB Host set to " + dbHost);
		
		String dbPort = properties.getProperty("db.port");
		if(dbPort == null) throw new RuntimeException("Property db.port not found, can't resolve DB Port");
		else LOGGER.info("DB Port set to " + dbPort);
		int port = Integer.parseInt(dbPort);
		
		databaseName = properties.getProperty("db.name");
		if(databaseName == null) throw new RuntimeException("Property db.name not found, can't resolve DB Name");
		else LOGGER.info("DB Name set to " + databaseName);
		
		String username = properties.getProperty("db.username");
		if(username == null) throw new RuntimeException("Property db.username not found, can't resolve DB Username");
		else LOGGER.info("DB Username set to " + username);
		
		String password = properties.getProperty("db.password");		
		if(password == null) throw new RuntimeException("Property db.password not found, can't resolve DB Password");
		
		String authDatabase = properties.getProperty("db.authDatabase");
		if(authDatabase == null) throw new RuntimeException("Property db.authDatabase not found, can't resolve Authentication Database");
		else LOGGER.info("Authentication Database set to " + authDatabase);
		
		List<ServerAddress> servers = new ArrayList<>();
		servers.add(new ServerAddress(dbHost, port));
		List<MongoCredential> credentials = new ArrayList<>();
		credentials.add(MongoCredential.createCredential(username, authDatabase, password.toCharArray()));
		mongoClient = new MongoClient(servers, credentials);

		morphia = new Morphia();
		this.datastore = morphia.createDatastore(mongoClient, databaseName);
		
	}
	
	public<T extends BaseMongoObject> List<T> find(T t){
		return datastore.queryByExample(t).asList();		
	}
	
	public<T> T fromDbObject(DBObject dbObject, Class<T> clazz){
		return morphia.fromDBObject(clazz, dbObject);
	}
	
	public MongoDatabase getDatabase() {
		return mongoClient.getDatabase(databaseName);
	}
	
	public String getDatabaseName() {
		return this.databaseName;
	}
	
	public MongoClient getMongoClient(){
		return this.mongoClient;
	}
	
	public Datastore getDatastore(){
		return this.datastore;
	}
	
	public<T extends BaseMongoObject> void save(T object){
		datastore.save(object);
	}
	
	public<T extends BaseMongoObject> void save(List<T> objects){
		datastore.save(objects);
	}

	@Override
	public void preDestroy() {
		mongoClient.close();
	}

}
