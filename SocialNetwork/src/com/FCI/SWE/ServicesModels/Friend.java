package com.FCI.SWE.ServicesModels;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Friend {
String from,to,status;


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
