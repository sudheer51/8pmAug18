package org.h2k.openmrs;

 
import java.io.IOException;

import org.h2k.openmrs.pages.FindAPatientRecordPage;
import org.h2k.openmrs.pages.HelperClass;
import org.h2k.openmrs.pages.ManageServicesTypesPage;
import org.h2k.util.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import jxl.read.biff.BiffException;

public class OpenMRSTests extends BaseClass{

	@Parameters({"patientName","username","password"})
	@Test(priority=1)
	public void verifyFindPatient(String patientName,String username,String password)
	{	
		HelperClass helper = new HelperClass(driver);
		FindAPatientRecordPage fPage = new FindAPatientRecordPage(driver);

		helper.login(username,password);
		fPage.navigatetoFindAPatientPage();
		boolean result = fPage.findAPatientRecord(patientName);
		Assert.assertTrue(result);	
		helper.logout();
	}
	@Parameters({"serviceName","username","password"})
	@Test(priority=2)
	public void verifyServiceType(String serviceName,String username,String password)
	{
		HelperClass helper = new HelperClass(driver);
		helper.login(username,password);
		ManageServicesTypesPage mPage = new ManageServicesTypesPage(driver);
		mPage.navigatetoServiceTypesPage();
		boolean result = mPage.verifyServiceType(serviceName);
		Assert.assertTrue(result);
		helper.logout();
	}


	
	@Test(priority=3,dataProvider="DP")
	public void verifyPatientList( String username,String password,String patientName)
	{	
		HelperClass helper = new HelperClass(driver);
		FindAPatientRecordPage fPage = new FindAPatientRecordPage(driver);

		helper.login(username,password);
		fPage.navigatetoFindAPatientPage();
		boolean result = fPage.findAPatientRecord(patientName);
		Assert.assertTrue(result);	
		helper.logout();
	}

	@DataProvider(name="DP")
	public String[][] feedDP() throws BiffException, IOException
	{
		String str[][] = readXLS();
		return str;
	}
	
	 

}
