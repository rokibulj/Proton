package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class TestJobSearchPage extends TestBase {
	
	@Test
	public void testNewJobsCount() {
		String text = jobSearchPage.totalJobWebElement.getText();
		Assert.assertEquals(text, "New Jobs (Total: 1 Jobs)");
	}
	}


