package TestCases;

import CommonUtils.Endpoints;
import ExecutionReports.CustomReporter;
import TestConfig.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(CustomReporter.class)

public class DeleteUser extends BaseTest {

    @Test(enabled=true, priority = 0)
    public void verify_deleteUser_workflow() throws IOException {
        RequestSpecification request = RestAssured.given();
        request.baseUri(environment.getProperty("BaseUri"));
        request.header("Content-Type", "multipart/form-data");
        request.multiPart("email","rich0345@gmail.com");
        request.multiPart("password","test12345");
        Response res = request.delete(Endpoints.deleteUser);
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getBody().jsonPath().get("responseCode").toString(),"200");
        Assert.assertEquals(res.getBody().jsonPath().get("message").toString(),"Account deleted!");
    }
}
