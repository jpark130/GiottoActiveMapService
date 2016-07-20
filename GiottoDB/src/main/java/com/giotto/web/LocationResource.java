package com.giotto.web;

import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.giotto.db.DBManager;
import com.giotto.things.Location;
import com.giotto.things.Person;

@Path("/location")
public class LocationResource {
	
  @GET
  @Path("/count")
  @Produces(MediaType.TEXT_PLAIN)
  public long count() throws UnknownHostException {
		return DBManager.count("Location");	  
  }
  
  @POST
  @Path("/find")
  @Consumes({"application/json"})
  public String getLocation(String jsonString){
	  try {
		  Location l = new Location(jsonString);
	      return l.toString();
	  } catch (Exception e) {
		  System.out.println(e);
	  }
	  return "";
  }
  
  @POST
  @Path("/post")
  @Consumes({"application/json"})
  public boolean postLocation(String jsonString){
	  try {
		  Location l = new Location(jsonString);
		  return DBManager.insert("Location", l);
	  } catch (Exception e) {
	      System.out.println(e);
	  }
	  return false;
  }
}
