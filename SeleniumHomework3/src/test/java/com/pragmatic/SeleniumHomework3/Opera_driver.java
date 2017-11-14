package com.pragmatic.SeleniumHomework3;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.util.concurrent.Service;

public class Opera_driver {

	static WebDriver driver;
	
	@Before
	public void setUp()
	{
System.setProperty("webdriver.opera.driver","C:\\selenium_drivers\\operadriver.exe");
		
		driver = new OperaDriver();
		
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
