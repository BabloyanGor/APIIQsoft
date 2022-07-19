package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import testData.APISVariables_GameLunching_RequestBody;
import utilities.ReadConfig;

import java.io.IOException;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public static Logger logger;
    APISVariables_GameLunching_RequestBody apisVariables_gameLunching_requestBody = new APISVariables_GameLunching_RequestBody();


    @BeforeSuite
    public void Start(){
        logger = Logger.getLogger("IQsoftAPI");
        PropertyConfigurator.configure("Log4j.properties");
        logger.info("API Test Suite start execution");
//        if (apisVariables_gameLunching_requestBody.getToken() == null){
//            logger.error("We have no Token for API tests execution");
//            Assert.fail();
//        }
    }
    @AfterSuite
    public void Finish() throws InterruptedException, IOException {

    }

}
