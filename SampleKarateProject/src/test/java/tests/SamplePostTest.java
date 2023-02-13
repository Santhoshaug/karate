package tests;

import com.intuit.karate.junit5.Karate;

public class SamplePostTest {
	
	@Karate.Test
    Karate testSample() {
        return Karate.run("SamplePost").relativeTo(getClass());
    }
 
 @Karate.Test
    Karate testTags() {
        return Karate.run("SamplePost").tags("@smoke1").relativeTo(getClass());
    }

}
