package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMTGettoknowDetails {
	
	 WebDriver driver;
	 public TMTGettoknowDetails(WebDriver driver)
	    {
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	    } 
	 
	 @FindBy(xpath = "//textarea[contains(@name,'textarea-field')]")
	    public WebElement txtEventName;
	 

}
