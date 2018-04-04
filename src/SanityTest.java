import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)



public class SanityTest {


    private static AndroidDriver<MobileElement> driver;

    public TestName name = new TestName();
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static void setUpTest() throws IOException, SAXException, ParserConfigurationException {
        // this will get the APP data from the XML
        String AppPackage = ReadAppDataFromXML.getData("AppPackage");
        String AppActivity = ReadAppDataFromXML.getData("appActivity");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        // the APP data from the XML that defined in the beggining of the before class is used here
        capabilities.setCapability("appPackage", AppPackage);
        capabilities.setCapability("appActivity", AppActivity);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void start() throws Exception {
        String ReportPath = ReadAppDataFromXML.getData("ReportPath");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportPath);

        // choose to append each test
        htmlReporter.setAppendExisting(true);
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name the test and add description
        test = extent.createTest("SanityTest", "sanity tests of BuyMe Mobile application");

        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "RoiY");

        // log results
        test.log(Status.INFO, "@Before class");
        // this will wait up to 10 sec to verify that the elemand is displayed
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    // this test verify the registration page functionality the final result is to verify that the Google account was selected
    public void SanityTest01_Registration_Page_Verification() {
        RegestrationScreen.UserArea(driver).click();
        RegestrationScreen.Registration(driver).click();
        // this step is used to scroll the page till the "continue" button will displayed
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/homeTab\"))"));
        boolean googleAccountPressed = false;
        try {
            RegestrationScreen.GoogleAccount(driver).click();
            googleAccountPressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "No Google Account was selected!! " + e.getMessage());

        } finally {
            if (googleAccountPressed = true) {
                try {
                    test.log(Status.PASS, "the Google Account was selected ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\1")).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        // this will return to the home screen
        RegestrationScreen.HomeTab(driver).click();
    }



    @Test
    // this test verify the home page functionality the final result is to verify that the gift budget was defined
    public void SanityTest02_Home_Page_Verification() {

        HomeScreen.CategorySelection(driver).click();
        HomeScreen.BusinessSelection(driver).click();
        HomeScreen.GiftBudget(driver).click();
        HomeScreen.GiftBudget(driver).sendKeys("200");
        boolean purchaseButtonPressed = false;
        try {
            HomeScreen.PurchaseButton(driver).click();
            purchaseButtonPressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "No Gift Budget was defined!! " + e.getMessage());
        } finally {
            if (purchaseButtonPressed = true) {
                try {
                    test.log(Status.PASS, "the Gift Budget was defined ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\2")).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    @Test
    // this test verify the sendar and receiver page functionality the final result is to verify that the next button is pressed successfully
    public void SanityTest03_SenderAndReceiver_Page_Verification() {
        SenderAndReceiver.ReceiverName(driver).click();
        SenderAndReceiver.ReceiverName(driver).sendKeys("Avivit");
        SenderAndReceiver.blessing(driver).click();
        SenderAndReceiver.blessing(driver).sendKeys("Mazal Tov");
        boolean NextButtonPressed = false;
        try {
            SenderAndReceiver.NextButton(driver).click();
            NextButtonPressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Not all the fields are filled with Data!! " + e.getMessage());

        } finally {
            if (NextButtonPressed = true) {
                try {
                    test.log(Status.PASS, "the next button  was pressed ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\3")).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    // this test verify the how to send the gift page functionality the final result is to verify that the next button is pressed successfully
    public void SanityTest04_HowToSend_Page_Verification() {
        HowToSend.RightAfterPayment(driver).click();
        HowToSend.RightAfterPayment(driver).click();
        HowToSend.ByMailCheckbox(driver).click();
        HowToSend.MailAdress(driver).sendKeys("roi@roi.com");
        boolean NextButtonPressed = false;
        try {
            SenderAndReceiver.NextButton(driver).click();
            NextButtonPressed = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Not all the fields are filled with Data!! " + e.getMessage());

        } finally {
            if (NextButtonPressed = true) {
                try {
                    test.log(Status.PASS, "the next button  was pressed ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\roi.yomtovyan\\Desktop\\4")).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    // this method is to enable thescreen shotes in the report
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }


        @AfterClass
        public static void after () {
            driver.quit();
            // build and flush report
            extent.flush();


        }

}
