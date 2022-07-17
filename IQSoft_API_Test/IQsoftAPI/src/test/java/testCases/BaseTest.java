package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ReadConfig;

import java.io.IOException;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public static Logger logger;

    @BeforeSuite
    public void Start(){
        logger = Logger.getLogger("craftBet");
        PropertyConfigurator.configure("Log4j.properties");
        logger.info("API Test Suite start execution");
    }
    @AfterSuite
    public void Finish() throws InterruptedException, IOException {

    }

}
