package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class ParentTest {
    public WebDriver webDriver;

    public ParentTest() {

    }

    @Before
    public void setUp() {
        File driverPath = new File( ".././drivers/chromedriver.exe" );
        System.setProperty( "webdriver.chrome.driver", driverPath.getAbsolutePath() );
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
