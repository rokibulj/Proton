package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchPage extends PageBase {
	
	@FindBy(id = "application_status_head_container")
	public WebElement totalJobWebElement;
	
	@FindBy(name = "submit")
	public WebElement jobSearchButton;

}
