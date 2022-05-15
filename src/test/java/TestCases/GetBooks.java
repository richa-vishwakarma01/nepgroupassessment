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

public class GetBooks extends BaseTest {

    @Test(enabled=true, priority = 2)
    public void verify_getUser_workflow() throws IOException {
        //String body= jsonUtils.getPayLoad("user");
        Response res= restManger.setBaseUri("BaseUri", Endpoints.getBooks)
                .build().getRequest();
        setResponsemap("getBooks", res);
        Assert.assertEquals(getResponseMap("getBooks").getStatusCode(),200);
        //Assert.assertEquals(getResponseMap("createUserResponse").getBody().jsonPath().get("responseCode").toString(),"201");
    }
}