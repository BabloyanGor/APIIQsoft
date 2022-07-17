package testCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.APIVariables_1;

public class API1_GameLaunch extends BaseTest {
    @BeforeClass
    public void setup() throws UnirestException, JSONException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://reqres.in/api/users?page=2")
                .asString();

        // Response body
        JSONObject body = new JSONObject(response.getBody());

        APIVariables_1 responseBody = new APIVariables_1();
        responseBody.setPage(Integer.parseInt(body.getString("page")));


        String total = body.getString("total");
        JSONArray data = body.getJSONArray("data");
        String firstOne = String.valueOf(data.get(0));
        JSONObject ArrayFirst = new JSONObject(firstOne);
        String id = ArrayFirst.getString("id");
        String email = ArrayFirst.getString("email");


        // Response headers
        JSONObject headers = new JSONObject(response.getHeaders());
        String date = headers.getString("date");
        System.out.println("Header date --->" + date);

        System.out.println("Page--->  " + responseBody.getPage());
        System.out.println();
        System.out.println("Total--->  " + total);
        System.out.println();
        System.out.println("ID--->  " + id);
        System.out.println();
        System.out.println("Email--->  " + email);

    }
    @Test
    public void test1(){
        Assert.assertTrue(true);
    }

}
