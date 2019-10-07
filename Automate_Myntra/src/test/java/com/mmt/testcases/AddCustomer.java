package com.mmt.testcases;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;

public class AddCustomer extends TestBase{

		@Test(priority = 1)
		public void AddCustomer()
		{
			driver.findElement(By.id(OR.getProperty("skipsignin"))).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("firstname"))));
			driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys("Abhinav");
			driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys("Bhatnagar");
			driver.findElement(By.xpath(OR.getProperty("address"))).sendKeys("Bangalore");
			driver.findElement(By.xpath(OR.getProperty("email"))).sendKeys("Abhinav@c.com");
			driver.findElement(By.xpath(OR.getProperty("tel"))).sendKeys("9512231726");
			driver.findElement(By.xpath(OR.getProperty("gender"))).click();
			driver.findElement(By.xpath(OR.getProperty("hobby"))).click();
			driver.findElement(By.xpath(OR.getProperty("txtlanguages"))).click();
			
			List<WebElement> lst = driver.findElements(By.tagName("a"));
			for(WebElement lang : lst) {
				if(lang.getText().contains("English")) {
					lang.click();
				}
				if(lang.getText().contains("Hindi")) {
					lang.click();
					break;
				}
			}
			driver.findElement(By.xpath(OR.getProperty("hobby"))).click();
			Select skill  = new Select(driver.findElement(By.id(OR.getProperty("skills"))));
//			skill.selectByValue("Java");
			skill.selectByVisibleText("C");
			Select country  = new Select(driver.findElement(By.id(OR.getProperty("country"))));
			country.selectByIndex(3);
			
//			driver.findElement(By.xpath(OR.getProperty("selcountrytxt"))).click();
//			List<WebElement> lstCountries = driver.findElements(By.xpath(OR.getProperty("selcountry")));
//			for(WebElement cntry: lstCountries) {
//				if(cntry.getText().contains("India")) {
//					cntry.click();
//				}
//			}
			
			Select year  = new Select(driver.findElement(By.id(OR.getProperty("year"))));
			year.selectByValue("1990");
			Select month  = new Select(driver.findElement(By.xpath(OR.getProperty("month"))));
			month.selectByValue("September");
			Select day  = new Select(driver.findElement(By.id(OR.getProperty("day"))));
			day.selectByValue("29");
			
			driver.findElement(By.id(OR.getProperty("fpass"))).sendKeys("Password1");
			driver.findElement(By.id(OR.getProperty("spass"))).sendKeys("Password1");
			driver.findElement(By.id(OR.getProperty("submit"))).click();
			
			Assert.assertTrue(IsElementPresent(By.id(OR.getProperty("msg"))));
			
		}
		
		@Test(priority = 2)
		public void ValidateAlerts() {
			
			
		}


}

















//@DataProvider
//public Object[][] getData(){
//	String sheetName = "AddCustomer";
//	int rows = excel.getRowCount(sheetName);
//	int columns = excel.getColumnCount(sheetName);
//	Object[][] data = new Object[rows-1][columns];
//	
//	for(int i = 2; i<rows; i++) {
//		for(int j = 0;j<columns;j++) {
//			data[i-2][j] = excel.getCellData(sheetName, j, i);
//		}
//	}
//	
//	return null;
//	
//}