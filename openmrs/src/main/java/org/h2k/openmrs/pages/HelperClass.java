package org.h2k.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	WebDriver driver;
	 public HelperClass(WebDriver driver) {

	 this.driver =driver;
	 }
	public void login(String username,String password)
	    {
	    	 
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Inpatient Ward")).click();
			driver.findElement(By.id("loginButton")).click();
	    }
	    public void logout()
	    {
	    	driver.findElement(By.cssSelector(".logout>a")).click();
	    }
}
