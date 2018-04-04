import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// this class is the Object repository of the registration page

public class RegestrationScreen {

    public static MobileElement element;

public  static MobileElement UserArea (MobileDriver driver){
    element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/profileTab"));
    return element;
}

    public  static MobileElement Registration (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/email"));
        return element;
    }

    public  static MobileElement GoogleAccount (MobileDriver driver){
        element= (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/googleButton"));
        return element;
    }

    public  static MobileElement HomeTab (MobileDriver driver) {
        element = (MobileElement) driver.findElement(By.id("il.co.mintapp.buyme:id/homeTab"));
        return element;
    }



    }
