package Data;

import org.testng.annotations.DataProvider;

public class AuthorizationData {
    @DataProvider
    public Object[][] authorizationData() {
        return new Object[][]{
                {"User123sdadsa", "User12345678!"},
                {"User123", "User12345678!sdsdsds"},
                {"User123sdadsa", "User12345678!sdsdsds"},
                {"", ""},
                {"User123", ""},
                {"User123", "User12345678!"}
        };
    }
}
