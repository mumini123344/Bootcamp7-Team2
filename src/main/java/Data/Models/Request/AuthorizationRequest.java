package Data.Models.Request;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "userName", "password" })
public class AuthorizationRequest {
    private String userName;
    private String password;

}
