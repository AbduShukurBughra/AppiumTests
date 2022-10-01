import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SimpleCalculation {
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


        //Test Case is 5 + 9 * 5 = 50
        //id
        ad.findElementById("com.android.calculator2:id/digit_5").click();
        // accessibility ID
        ad.findElementByAccessibilityId("plus").click();
        //xPath
        ad.findElementByXPath("//android.widget.Button[@text='9']").click();
//        ad.findElementById("com.android.calculator2:id/digit_9").click();

        //AndroidUIAutomator
        ad.findElementByAndroidUIAutomator("text(\"×\")").click();
        //id
        ad.findElementById("com.android.calculator2:id/digit_5").click();

        //verify result as 50
       String resultText =  ad.findElementByAndroidUIAutomator("resourceId(\"com.android.calculator2:id/result\")").getText();
       if(resultText.equals("50")){
           System.out.println("PASS : Result matched");
       }else{
           System.out.println("FAIL : Result not matched");
       }
    }
}
