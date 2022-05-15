package TestCases;

import CommonUtils.Endpoints;
import CommonUtils.JSONUtils;
import TestConfig.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class createUser  extends BaseTest {

    @Test(enabled=true, priority = 0)
    public void verify_createUser_workflow() throws IOException {
        String body= jsonUtils.getPayLoad("user");
        Response res= restManger.setBaseUri("BaseUri", Endpoints.user).setHeaders("Authorization","Basic VGVzdFZZOlRlc3RAMTIz").setHeaders("Content-Type","application/json").
                setBody(body).build().postRequest();
        setResponsemap("createUserResponse", res);
        res.getBody().prettyPrint();
        Assert.assertEquals(getResponseMap("createUserResponse").getStatusCode(),201);

//        Assert.assertEquals(getResponseMap("createUserResponse").getBody().jsonPath().get("responseCode").toString(),"201");
    }
}
