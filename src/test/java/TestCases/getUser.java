package TestCases;

import CommonUtils.Endpoints;
import ExecutionReports.CustomReporter;
import TestConfig.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(CustomReporter.class)

public class getUser extends BaseTest {

    @Test(enabled=true, priority = 1)
    public void verify_getUser_workflow() throws IOException {
        //String body= jsonUtils.getPayLoad("user");
        String userID =getResponseMap("createUserResponse").getBody().jsonPath().get("userID");
        Response res= restManger.setBaseUri("BaseUri", Endpoints.user +"/"+userID).setHeaders("Authorization","Basic T3NsbzpUZXN0QDEyMw==")
                .build().getRequest();
        setResponsemap("createUserResponse", res);
        Assert.assertEquals(getResponseMap("createUserResponse").getStatusCode(),200);
        //Assert.assertEquals(getResponseMap("createUserResponse").getBody().jsonPath().get("responseCode").toString(),"201");
    }
}
