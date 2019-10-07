package com.mmt.testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mmt.base.TestBase;


public class FilterTest extends TestBase {
	
	@Test(priority = 1)
	public void NavigateToCategories() {
		Assert.assertTrue(IsElementPresent(By.xpath(OR.getProperty("lnk_Men"))));
	//	driver.findElement(By.xpath(OR.getProperty("lnk_Men"))).click();
		repo.log("Click on Men");
		
		Actions builder = new Actions(driver);
		Action mouseHoverMen = builder.moveToElement(driver.findElement(By.xpath(OR.getProperty("lnk_Men")))).build();
		mouseHoverMen.perform();
		driver.findElement(By.xpath(OR.getProperty("lnk_tshirt"))).click();
		
		
	}
	
	@Test(priority = 2)
	public void ValidateFilters() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertTrue(IsElementPresent(By.xpath(OR.getProperty("lst_brandList"))));
		repo.log("Filters option is displayed");
		
	}
	
	@Test(priority = 3)
	public void ValidateDisplayedBreadCrumb() {
		Assert.assertTrue(IsElementPresent(By.xpath(OR.getProperty("brdCrumb"))));
		repo.log("Breadcrumb is displayed");
	}
	
	@Test(priority = 4)
	public void ValidateSelectedFilters() {
		driver.findElement(By.xpath(OR.getProperty("chk_BrandRoadster"))).click();
		Assert.assertTrue(IsElementPresent(By.xpath(OR.getProperty("lbl_Roadster"))));
		repo.log("Filter is selected");
	}
}
