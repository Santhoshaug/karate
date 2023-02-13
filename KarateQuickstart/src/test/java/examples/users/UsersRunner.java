package examples.users;

import com.intuit.karate.junit5.Karate;

class UsersRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }   
    
    @Karate.Test
    Karate testTags() {
        return Karate.run("users").tags("@jsonPlaceholder").relativeTo(getClass());
    }

}
