package com.malk;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class Testing {

	
	
	private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

		  @Before
		  public void setUp() {
		    helper.setUp();
		  }

		  @After
		  public void tearDown() {
		    helper.tearDown();
		  }
	     
		  
		  @Test
		  public  void EntityTesting()
		  {
			  Entity e=IosContactManage.funDataStore("malkaraj", 21, "chennai", "malkaraj99@gmail.com", "421");
			  
			  assertEquals(e.getProperty("Name"),"malkaraj");
			  
			  
		  }
		  
		  
		  
		  

}
