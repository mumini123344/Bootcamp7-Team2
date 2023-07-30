import Data.AuthorizationData;
import Data.Models.Request.AuthorizationRequest;
import Steps.AuthorizationStep;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

@Epic("User Authorization")
@Feature("Authorize User")
public class AuthorizationTest {
    AuthorizationStep authorizationStep = new AuthorizationStep();
    String correctUser;
    String correctPassword;

    @Test(dataProvider = "authorizationData",dataProviderClass = AuthorizationData.class,priority=0)
    public void authorizeUserTest(String userName, String password) throws JsonProcessingException {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();
        authorizationRequest.setUserName(userName);
        authorizationRequest.setPassword(password);

        Response response = authorizationStep.getRequest(authorizationRequest, userName);

        assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        if(response.getStatusCode()==200){
            correctUser=authorizationRequest.getUserName();
            correctPassword=authorizationRequest.getPassword();
        }
    }
}
