package com.pragmatic.SeleniumHomework3;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigureYourCar {
	static WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
	}
	
	@Test
	public void clickChecboxes() {
		WebElement airBagsCheckbox=driver.findElement(By.name("airbags"));
		WebElement parkingSensorCheckbox=driver.findElement(By.name("parksensor"));
		
		
		
		if (!airBagsCheckbox.isSelected()) {
			airBagsCheckbox.click();
		}
		if (!parkingSensorCheckbox.isSelected()) {
			parkingSensorCheckbox.click();
		}
		
		assertTrue(airBagsCheckbox.isSelected());
		assertTrue(airBagsCheckbox.isSelected());
		//assertEquals("true", airBagsCheckbox.getAttribute("checked"));
		
	}
	
	@After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
	

}
