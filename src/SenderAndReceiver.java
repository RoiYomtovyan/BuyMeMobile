import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

// this class is the Object repository of the Sender And Receiver page
public class SenderAndReceiver {

    public static MobileElement element;

    public  static MobileElement ReceiverName (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/toEditText"));
        return element;
    }

    public  static MobileElement blessing (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/blessEditText"));
        return element;
    }
    public  static MobileElement NextButton (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton"));
        return element;
    }
}
