package testCases;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.APISVariables_GameLunching_Common;
import testData.APIVariables_GameLaunching;

public class API1_GameLaunch extends BaseTest {
    APIVariables_GameLaunching gameLaunching = new APIVariables_GameLaunching();
    APISVariables_GameLunching_Common apisVariables_gameLunching_common = new APISVariables_GameLunching_Common();
    int partnerID = 51;
    @BeforeClass
    public void setup() throws UnirestException, JSONException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(apisVariables_gameLunching_common.urlClient51)
                .header("Content-Type", "application/json")
                .body("{\r\n  \"PartnerId\": 51,\r\n  \"LanguageId\": \"en\",\r\n  \"Token\": \"8e7e58ad-a241-4f82-918e-6be53a3e5481\",\r\n  \"IsForMobile\": false,\r\n  \"GameId\": 21001,\r\n      \"Domain\": \"betfaro.com\"\r\n    }\r\n\r\n")
                .asString();


        // Response body
        JSONObject responseBody = new JSONObject(response.getBody());

        gameLaunching.setCod(response.getCode());

        gameLaunching.setResponseCode(Integer.parseInt(responseBody.getString("ResponseCode")));

        gameLaunching.setDescription(String.valueOf(responseBody.getString("Description")));

        gameLaunching.setResponseObject(responseBody.getString("ResponseObject"));

        System.out.println();




//        String total = body.getString("total");
//        JSONArray data = body.getJSONArray("data");
//        String firstOne = String.valueOf(data.get(0));
//        JSONObject ArrayFirst = new JSONObject(firstOne);
//        String id = ArrayFirst.getString("id");
//        String email = ArrayFirst.getString("email");
//        System.out.println("Total--->  " + total);
//        System.out.println();
//        System.out.println("ID--->  " + id);
//        System.out.println();
//        System.out.println("Email--->  " + email);

        // Response headers
//        JSONObject headers = new JSONObject(response.getHeaders());
//        String date = headers.getString("date");
//        System.out.println("Header date --->" + date);

    }

    @Test(priority = 1)
    @Description("Verify game launching API_s Status cod equals 200")
    public void codTest() {
        Assert.assertEquals(gameLaunching.getCod(), 200);
    }

    @Test(priority = 2)
    @Description("Verify game launching API_s Response cod equals 0")
    public void responseCodeTest() {
        Assert.assertEquals(gameLaunching.getResponseCode(), 0);
    }

    @Test(priority = 3)
    @Description("Verify game launching API_s Response Description is null")
    public void responseDescriptionTest() {
        Assert.assertEquals(gameLaunching.getDescription(), null);
    }

    @Test(priority = 4)
    @Description("Verify game launching API_s Response Object not null")
    public void responseObjectTest() {
        System.out.println();
        Assert.assertNotEquals(gameLaunching.getResponseObject(), "null");
        System.out.println();
    }



}
