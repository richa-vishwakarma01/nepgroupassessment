package TestCases;

import CommonUtils.Endpoints;
import CommonUtils.JSONUtils;
import Models.Books;
import Models.CollectionOfIsbn;
import TestConfig.BaseTest;
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
        String body= Books.builder().userId(userID).collectionOfIsbns(new ArrayList<CollectionOfIsbn>().add(CollectionOfIsbn.builder().isbn(bookID).build())).build().toString();

        //String body= Books.builder().userId(userID).collectionOfIsbns(CollectionOfIsbn.builder().isbn(bookID).build()).build().toString();
        Response res= restManger.setBaseUri("BaseUri", Endpoints.user).setHeaders("Authorization","Basic VGVzdFZZOlRlc3RAMTIz").setHeaders("Content-Type","application/json").
                setBody(body).build().postRequest();
        setResponsemap("createUserResponse", res);
        res.getBody().prettyPrint();
        Assert.assertEquals(getResponseMap("createUserResponse").getStatusCode(),201);


    }



}
