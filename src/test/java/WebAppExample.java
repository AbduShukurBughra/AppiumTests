import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebAppExample {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        //Desired Capabilities, system platform
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Bughra");
//        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\HP\\Desktop\\APK\\ApiDemos-debug.apk");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        //Android Driver initialization
        AndroidDriver<AndroidElement> ad = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        //implicit wait
        ad.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        //go to url google.com
        ad.get("https://www.google.com/");

        // click on Sign in link button
        ad.findElement(By.xpath("//a[text()='Sign in']")).click();

        Thread.sleep(5000);

        //close the driver
        ad.close();


    }
}