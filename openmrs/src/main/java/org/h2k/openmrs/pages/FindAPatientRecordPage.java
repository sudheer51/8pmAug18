package org.h2k.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindAPatientRecordPage {

	WebDriver driver;
	public FindAPatientRecordPage(WebDriver driver) {
		this.driver = driver;
	}
	public boolean findAPatientRecord(String patientName)
    {
    	driver.findElement(By.id("patient-search")).sendKeys(patientName);
		String actual = driver.findElement(By.xpath("//table[@id='patient-search-results-table']/tbody/tr/td[2]")).getText();
		System.out.println("Actual value is " + actual );
		boolean result= actual.trim().equals(patientName);
		return result;
    }
	public void navigatetoFindAPatientPage()
	{
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
	}

}
