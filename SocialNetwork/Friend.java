-package com.FCI.SWE.ServicesModels;

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




public Boolean saveFriend() {
	DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();
	Query gaeQuery = new Query("friends");
	PreparedQuery pq = datastore.prepare(gaeQuery);
	List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

	Entity employee = new Entity("friends", list.size() + 1);

	employee.setProperty("requestfrom", this.from);
	employee.setProperty("requestto", this.to);
	employee.setProperty("status", this.status);
	datastore.put(employee);

	return true;

}



}
