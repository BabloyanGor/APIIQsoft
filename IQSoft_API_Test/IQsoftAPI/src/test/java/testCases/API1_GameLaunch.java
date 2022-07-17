package testCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class API1_GameLaunch {
    @BeforeClass
    public void setup() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://reqres.in/api/users?page=2")
                .asString();

    }
    @Test
    public void test1(){
        Assert.assertTrue(true);
    }

}
