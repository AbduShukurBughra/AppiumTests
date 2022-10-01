import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumExam {

    public static void main(String[] args) throws MalformedURLException {

        //Desired Capabilities, system platform
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");

        //Desired Capabilities specific to the application appPackage and appActivity
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        //Android Driver initialization
        AndroidDriver<AndroidElement> ad = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println("Application Started...");
    }
}
