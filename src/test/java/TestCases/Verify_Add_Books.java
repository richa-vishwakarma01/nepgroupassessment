package TestCases;

import CommonUtils.Endpoints;
import CommonUtils.JSONUtils;
import Models.Books;
import Models.CollectionOfIsbn;
import TestConfig.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Verify_Add_Books  extends BaseTest {


    @Test(enabled=true, priority = 3)
    public void add_book_to_user() throws IOException {
        String bookID = getResponseMap("getBooks").getBody().jsonPath().get("books[1].isbn");
        String userID =getResponseMap("createUserResponse").getBody().jsonPath().get("userID");
        ArrayList<CollectionOfIsbn> collectionOfIsbns=new ArrayList<CollectionOfIsbn>();
        CollectionOfIsbn isbn = CollectionOfIsbn.builder().isbn(bookID).build();
        Books body = Books.builder().userId(userID).collectionOfIsbns(collectionOfIsbns).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonbody = mapper.writeValueAsString(body);
        Response res= restManger.setBaseUri("BaseUri", Endpoints.getBooks).setHeaders("Authorization","Basic T3NsbzpUZXN0QDEyMw==").setHeaders("Content-Type","application/json").
                setBody(jsonbody).build().postRequest();
        setResponsemap("addBooks", res);
        res.getBody().prettyPrint();
        Assert.assertEquals(getResponseMap("addBooks").getStatusCode(),201);


    }



}
