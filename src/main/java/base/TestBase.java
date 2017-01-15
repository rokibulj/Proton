package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.JobSearchPage;

public class TestBase extends Driver {
	public JobSearchPage jobSearchPage;

	@BeforeSuite
	public void setup() {
		if (Boolean.valueOf(getProperty("saucelabs"))) {
			Saucelabs sauce = new Saucelabs();
			sauce.setSaucelabs();
			driver = sauce.driver;
		} else {
			setDriver();
		}

		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
