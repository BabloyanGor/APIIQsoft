package testCases;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Description;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.APISVariables_GameLunching_RequestBody;
import testData.APIVariables_GameLaunching_Response;

public class API1_GameLaunch extends BaseTest {
    APIVariables_GameLaunching_Response gameLaunching = new APIVariables_GameLaunching_Response();
    APISVariables_GameLunching_RequestBody apisVariables_gameLunching_Request_body = new APISVariables_GameLunching_RequestBody();
    int partnerID = 51;
    @BeforeClass
    public void setup() throws UnirestException, JSONException {
        Gson gson = new Gson();

        String url = "https://production.iqsoftllc.com/51/api/Integration/OpenGame";

        apisVariables_gameLunching_Request_body.setPartnerId(51);
        apisVariables_gameLunching_Request_body.setLanguageId("en");
        apisVariables_gameLunching_Request_body.setToken("8e7e58ad-a241-4f82-918e-6be53a3e5481");
        apisVariables_gameLunching_Request_body.setIsForMobile("false");
        apisVariables_gameLunching_Request_body.setGameId(21001);
        apisVariables_gameLunching_Request_body.setDomain("betfaro.com");
        String requestBodyValue = gson.toJson(apisVariables_gameLunching_Request_body);

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(requestBodyValue)
                .asString();
        logger.info("Game Launching API request was sent");

        // Response body
        JSONObject responseBody = new JSONObject(response.getBody());

        gameLaunching.setCod(response.getCode());

        gameLaunching.setResponseCode(Integer.parseInt(responseBody.getString("ResponseCode")));

        gameLaunching.setDescription(String.valueOf(responseBody.getString("Description")));

        gameLaunching.setResponseObject(responseBody.getString("ResponseObject"));

        System.out.println();

    }





    @Test(priority = 1)
    @Description("Verify game launching API_s Status cod (need to be 200)")
    public void codTest() {

        Assert.assertEquals(gameLaunching.getCod(), 200);
        logger.info("Game Launching API Response status was checked");
        logger.info("---------------------------------------------------------------");
    }

    @Test(priority = 2)
    @Description("Verify game launching API_s Response cod  (need to be 0)")
    public void responseCodeTest() {
        Assert.assertEquals(gameLaunching.getResponseCode(), 0);
        logger.info("Game Launching API Response Cod was checked");
        logger.info("---------------------------------------------------------------");
    }

    @Test(priority = 3)
    @Description("Verify game launching API_s Response Description is (need to be null)")
    public void responseDescriptionTest() {
        Assert.assertEquals(gameLaunching.getDescription(), null);
        logger.info("Game Launching API Response Error Description was checked");
        logger.info("---------------------------------------------------------------");
    }

    @Test(priority = 4)
    @Description("Verify game launching API_s Response Object (need not be null)")
    public void responseObjectTest() {
        Assert.assertNotEquals(gameLaunching.getResponseObject(), "null");
        logger.info("Game Launching API Response Object was checked");
        logger.info("---------------------------------------------------------------");
    }











    @AfterClass
    public void tearDown(){

    }

}
