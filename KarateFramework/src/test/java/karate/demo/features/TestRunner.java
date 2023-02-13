package karate.demo.features;

import com.intuit.karate.junit5.Karate;

public class TestRunner {
	
	@Karate.Test
    Karate testSample() {
        return Karate.run("ReadData").relativeTo(getClass());
    }
 
 @Karate.Test
    Karate testTags() {
        return Karate.run("ReadData").tags("@smoke").relativeTo(getClass());
    }
 

}
