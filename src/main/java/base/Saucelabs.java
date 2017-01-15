package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ReadProperties;

import java.net.MalformedURLException;
import java.net.URL;

public class Saucelabs extends ReadProperties {
	DesiredCapabilities caps;
	public static WebDriver driver;

	public void setSaucelabs() {
		String userName = getSaucelabsProperty("userName");
		String accessKey = getSaucelabsProperty("accessKey");
		String url = "https://" + userName + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub";
		caps = setcapabilities();

		try {
			driver = new RemoteWebDriver(new URL(url), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get(getProperty("appUrl"));
	}

	public DesiredCapabilities setcapabilities() {
		String browser = getSaucelabsProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else {
			caps = DesiredCapabilities.firefox();
		}

		caps.setCapability("version", getSaucelabsProperty("browserVersion"));
		caps.setCapability("platform", getSaucelabsProperty("operatingSystem"));

		return caps;
	}
}
