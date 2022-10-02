import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverMethods {
    public static void main(String[] args) throws MalformedURLException {

        //Desired Capabilities, system platform
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
        caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\HP\\Desktop\\APK\\ApiDemos-debug.apk");

        //Android Driver initialization
        AndroidDriver<AndroidElement> ad = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        System.out.println(ad.getCurrentPackage());// This will give you the package name
        System.out.println(ad.getContext());// to get the context name
        System.out.println(ad.getOrientation());// to get the orientation
        System.out.println(ad.currentActivity());// to get the current activity
        System.out.println(ad.getBatteryInfo().getState());// to get the battery information
        System.out.println(ad.isDeviceLocked());// to check if the device is locked
        System.out.println(ad.location().getAltitude()+ " "+ad.location().getLatitude()+ " "+ad.location().getLongitude());


        ad.closeApp();//close the application
        ad.lockDevice();//lock the device
        ad.close();//close the android driver


//        //implicit wait
//        ad.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//
//        //Create an object of AndroidTouchAction Class
//        AndroidTouchAction touchAction = new AndroidTouchAction(ad);
    }
}
