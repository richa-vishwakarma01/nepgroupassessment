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

public class UpdateUser extends BaseTest {

    @Test(enabled=true, priority = 0)
    public void verify_updateUser_workflow() throws IOException {
        RequestSpecification request = RestAssured.given();
        request.baseUri(environment.getProperty("BaseUri"));
        request.header("Content-Type", "multipart/form-data");
        request.multiPart("name","RichaVish089");
        request.multiPart("email","rich034@gmail.com");
        request.multiPart("password","test12345");
        request.multiPart("title","Mr");
        request.multiPart("birth_date",12);
        request.multiPart("birth_month","December");
        request.multiPart("birth_year",1999);
        request.multiPart("firstname","Test");
        request.multiPart("lastname","Test1");
        request.multiPart("company","ABC");
        request.multiPart("address1","Svoldergata");
        request.multiPart("address2","Solli");
        request.multiPart("country","Norway");
        request.multiPart("zipcode",0271);
        request.multiPart("state","Oslo");
        request.multiPart("city","Oslo");
        request.multiPart("mobile_number",93998078);
        Response res = request.put(Endpoints.updateUser);
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getBody().jsonPath().get("responseCode").toString(),"200");
        Assert.assertEquals(res.getBody().jsonPath().get("message").toString(),"User updated!");
    }

}
