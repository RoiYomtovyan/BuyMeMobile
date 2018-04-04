import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

// this class is the Object repository of the How To Send page
public class HowToSend {

    public static MobileElement element;

    public  static MobileElement RightAfterPayment (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/nowRadioButton"));
        return element;
    }

    public  static MobileElement ByMailCheckbox (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("new UISelectior().index(12).clickable(true)"));
        return element;
    }

    public  static MobileElement MailAdress (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/description"));
        return element;
    }
    public  static MobileElement NextButton (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton"));
        return element;
    }
}
