package TestCases;

import CommonUtils.Endpoints;
import CommonUtils.JSONUtils;
import ExecutionReports.CustomReporter;
import TestConfig.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomReporter.class)
public class createUser  extends BaseTest {

    @Test(enabled=true, priority = 0)
    public void verify_createUser_workflow() throws IOException {
        String body= jsonUtils.getPayLoad("user");
        Response res= restManger.setBaseUri("BaseUri", Endpoints.user).setHeaders("Authorization","Basic T3NsbzpUZXN0QDEyMw==").setHeaders("Content-Type","application/json").
                setBody(body).build().postRequest();
        setResponsemap("createUserResponse", res);
        res.getBody().prettyPrint();
        Assert.assertEquals(getResponseMap("createUserResponse").getStatusCode(),201);

//        Assert.assertEquals(getResponseMap("createUserResponse").getBody().jsonPath().get("responseCode").toString(),"201");
    }
}
