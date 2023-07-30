package Steps;
import Data.Models.Request.AuthorizationRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class AuthorizationStep {

    ObjectMapper mapper = new ObjectMapper();
    @Step("Make Authorization")
    public Response getRequest(AuthorizationRequest request, String expectedName) throws JsonProcessingException {
        String requestBody = mapper.writeValueAsString(request);
        Response response = RestAssured.given()
                .filter(new AllureRestAssured())
                .baseUri("https://bookstore.toolsqa.com")
                .basePath("/Account/v1/Authorized")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post();

        return response;
    }
}
