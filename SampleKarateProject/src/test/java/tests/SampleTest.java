package tests;

import com.intuit.karate.junit5.Karate;

public class SampleTest {
	
	@Karate.Test
    Karate testSample() {
        return Karate.run("SampleGET").relativeTo(getClass());
    }
 
 @Karate.Test
    Karate testTags() {
        return Karate.run("SampleGET").tags("@smoke").relativeTo(getClass());
    }

}
