import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

// this class is the Object repository of the Home Screen page
public class HomeScreen {

    public static MobileElement element;

    public  static MobileElement CategorySelection (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.linkText("גיפט קארד למסעדות שף"));
        return element;
    }

    public  static MobileElement BusinessSelection (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("new UISelectior().index(3).clickable(true)"));
        return element;
    }

    public  static MobileElement GiftBudget (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/priceEditText"));
        return element;
    }

    public  static MobileElement PurchaseButton (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/purchaseButton"));
        return element;
    }
}
