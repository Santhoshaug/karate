package com.org.karate;

import com.intuit.karate.junit5.Karate;
public class TestbasicAuthRunner {
	
	 @Karate.Test
	    Karate testSample() {
	        return Karate.run("BasicAuthorization").relativeTo(getClass());
	    }

	 @Karate.Test
	    Karate testTags() {
	        return Karate.run("BasicAuthorization").tags("@getusersdefault").relativeTo(getClass());
	    }
}