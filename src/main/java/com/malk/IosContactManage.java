package com.malk;

import java.io.BufferedReader;

//import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;



/**
 * Servlet implementation class IosContactManage
 */
@WebServlet("/IosContactManage")
public class IosContactManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IosContactManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    public static Entity funDataStore(String name,int age,String Place,String Email,String address)
    {
    	UserDetailsPOJO us=new UserDetailsPOJO();
    	us.setEmail(Email);
    	us.setAge(age);
    	us.setName(name);
    	us.setPlace(Place);
    	us.setAddress(address);
    	
    	Entity e=new Entity("user",us.getEmail());
    
		e.setProperty("Name",us.getName() );
		e.setProperty("Age",us.getAge());
		e.setProperty("Place",us.getPlace());
		e.setProperty("Email",us.getEmail());
		e.setProperty("Address",us.getAddress());
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(e);
		System.out.print("data added");
    	 return e;
    	
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	   List<String >list =new ArrayList<>() ;
	   DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	   

	            
	           Query qp=new Query("user");
	            PreparedQuery pq = datastore.prepare(qp);
	            
	            
	            
	            for (Entity result : pq.asIterable()) {
		        
	            	ObjectMapper Obj = new ObjectMapper();
	            	  String ans=Obj.writeValueAsString(result.getProperties());
	            	  
	            	  list.add(ans);
	            	  
	            
	            }
	            
	            PrintWriter out=response.getWriter();
	           
		out.println(list.toString());
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  JsonNode json=null;
		  try {
		  //  JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		    
			  String str=jb.toString();
			  ObjectMapper mapper = new ObjectMapper();
			   json = mapper.readTree(str);
			    
			  
		  } catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }
		 
		String name=json.get("Name").asText();
		int age=json.get("Age").asInt();
		String email=json.get("Email").asText();
		String place=json.get("Place").asText();
		String address=json.get("Address").asText();
		

		  


	/*String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String place=request.getParameter("place");
		  String email= request.getParameter("email");
		  String address=request.getParameter("address");
		
		  PrintWriter out=response.getWriter();
			out.println("added successfully");
		*/	
		IosContactManage.funDataStore(name, age, place, email,address);
	
	}
	//updation the existing value in datastore
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  JsonNode json=null;
		  try {
		  //  JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		    
			  String str=jb.toString();
			  ObjectMapper mapper = new ObjectMapper();
			   json = mapper.readTree(str);
			    
			  
		  } catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }
		 
		String name=json.get("Name").asText();
		int age=json.get("Age").asInt();
		String email=json.get("Email").asText();
		String place=json.get("Place").asText();
		String address=json.get("Address").asText();
		
		
	/*	String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String place=request.getParameter("place");
			  String email= request.getParameter("email");
			  String address=request.getParameter("address");*/
			
			  PrintWriter out=response.getWriter();
				out.println("updated successfully!!");
				
			IosContactManage.funDataStore(name, age, place, email,address);
		
		
		
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  JsonNode json=null;
		  try {
		  //  JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		    
			  String str=jb.toString();
			  ObjectMapper mapper = new ObjectMapper();
			   json = mapper.readTree(str);
			    
			  
		  } catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }
		 
		 String email= json.get("Email").asText();
		
		//String email= request.getParameter("email");
		DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
		Key userKey=KeyFactory.createKey("user",email);
		datastore.delete(userKey);
		response.getWriter().print("successfully deleted");
	}
	

}
