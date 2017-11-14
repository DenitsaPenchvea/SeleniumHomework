package com.pragmatic.SeleniumHomework3;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;;


public class PragmaticBackend {
	
	static WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://shop.pragmatic.bg/admin");
	}
	

	@Test
	public void loginBackedn() 
	{
		WebElement usernameTbx=driver.findElement(By.name("username"));
		WebElement passwordTbx=driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("#form a.button"));
		
		usernameTbx.sendKeys("admin");
		passwordTbx.sendKeys("parola");
		loginBtn.click();
		
		WebElement adminHeader=driver.findElement(By.cssSelector("#header span"));
		
		assertEquals("admin", adminHeader.getText());
		

	}
	
	@Test
	public void loginBackednFail() 
	{
		WebElement usernameTbx=driver.findElement(By.name("username"));
		WebElement passwordTbx=driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("#form a.button"));
		
		usernameTbx.sendKeys("wronguser");
		passwordTbx.sendKeys("parola");
		loginBtn.click();
		
		WebElement waringMessage=driver.findElement(By.cssSelector("#content .warning"));
		
		assertEquals("No match for Username and/or Password.", waringMessage.getText());

	}
	
	@Test
	public void checkDD() throws InterruptedException 
	{
		loginBackedn();
		Select selectRangeDD =new Select(driver.findElement(By.cssSelector("#range")));
		selectRangeDD.selectByValue("week");
		WebElement option=selectRangeDD.getFirstSelectedOption();
		WebElement chartSunday=driver.findElement(By.xpath("//*[@id='report']/div[1]/div[1]/div[1]"));
		assertEquals("This Week", option.getText());
		assertEquals("Sun", chartSunday.getText());	
	}
	
	
	@After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
