package org.h2k.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BaseClass {
	

	protected WebDriver driver;
	@Parameters({"url","browserType"})
	@BeforeTest
	public void launchApplication(String url,String browserType)
	{
		switch(browserType) 
		{	
			case "FF":
				System.out.println("in FF");
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "IE":
				System.out.println("in IE");
				System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				//zoom set to 100%
				//Enabled protected mode for all the zones..
				break;
			case "CH":
				System.out.println("in CH");
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected  String[][] readXLS() throws BiffException, IOException {
		File f = new File("Data.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sheet = wb.getSheet(0);//0 refers to first sheet wb.getSheetName("sheetname");
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		String data[][]= new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{//getCell(col,row)
				data[i][j]=sheet.getCell(j,i).getContents();
				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}

}
