package org.h2k.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServicesTypesPage {
	WebDriver driver;
	public ManageServicesTypesPage(WebDriver driver) {
		this.driver= driver;
	}

	public void navigatetoServiceTypesPage()
	{
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
	}
	 
	public boolean verifyServiceType(String serviceName)
	{
		boolean result = false;
		List<WebElement> pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
		System.out.println("Number of pages " + pageList.size());
		outer:
		for(int i=0;i<pageList.size();i++)
		{
			pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
			pageList.get(i).click();
			List<WebElement> trList = driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-of-type(1)"));
			System.out.println("Number of table rows" + trList.size());
			for(int j=0;j<trList.size();j++)
			{
					if(trList.get(j).getText().contains(serviceName))
					{
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!Service Found!!!!!!!!!!!!!!!!!!!!!!");
						result = true;
						break outer;
					}
			}
		}
		 return result;
	}
    
}
