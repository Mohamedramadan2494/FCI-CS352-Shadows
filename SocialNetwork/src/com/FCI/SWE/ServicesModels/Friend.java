	package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
/**
 * <h1>Friend class</h1>
 * <p>
 * This class will act as a model for friend, it will holds friends request
 * </p>
 *
 * @author Mohamed Ramadan
 * @version 1.0
 * @since 2014-02-12
 */
public class Friend {
String from,to,status;
/**
 * Constructor accepts request data
 * 
 * @param f
 *            request sender
 * @param t
 *           request receiver
 * @param s
 *         request status 
 */


public Friend(String f, String t, String s) {
	this.from=f;;
	this.to=t;
	this.status=s;
}





public String getFrom() {
	return from;
}

public String getTo() {
	return to;
}

public String getStatus() {
	return status;
}

/**
 * 
 * This static method will form request entity class using users names
 * status to identify status of request
 * 
 * @param to
 *           request receiver           
 * @param from
 *         request sender   
 * @param s
 *            request status
 * @return Constructed user entity
 */
public static boolean request(String to,String from,String s) {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	Query gaeQuery = new Query("friends");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	for (Entity entity : pq.asIterable()) {
		if (entity.getProperty("RequestTo").toString().equals(to)&&
		   entity.getProperty("RequestFrom").toString().equals(from)) {
			entity.setProperty("Status",s);
			datastore.put(entity);
			
			return true;
		}
		
	}

	return false;
}

/*public  void changeStatus() {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	Query gaeQuery = new Query("friends");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	for (Entity entity : pq.asIterable()) {
		if (entity.getProperty("RequestTo").toString().equals(to)&&
		   entity.getProperty("RequestFrom").toString().equals(from)) {
			System.out.println(entity.getProperty("Status"));
			entity.setProperty("Status","accept");
			datastore.put(entity);
			System.out.println(entity.getProperty("Status"));
		}
		
	}

	
}*/

/**
 * This method will be used to save request object in datastore
 * 
 * @return boolean if request is saved correctly or not
 */
public Boolean saveFriend() {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();
	Query gaeQuery = new Query("friends");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

	Entity employee = new Entity("friends", list.size() + 1);

	employee.setProperty("RequestFrom", this.from);
	employee.setProperty("RequestTo", this.to);
	employee.setProperty("Status", this.status);
	datastore.put(employee);

	return true;

}



}
