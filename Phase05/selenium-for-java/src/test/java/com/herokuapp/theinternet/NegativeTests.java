package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test(priority = 1, groups = { "negativeTests", "smokeTests" })
	public void incorrectUsernameTest() {
		
		System.out.println("Start Incorrect Login Test");
		// create driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAHUL JAIN\\eclipse-workspace\\selenium-for-java\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// sleep for 3 seconds
		sleep(3000);
		// maximize browser window
		driver.manage().window().maximize();
		// open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");
		sleep(3000);
		// enter the user name
		String username = "incorrectUsername";
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys(username);
		// enter the password
		String password = "SuperSecretPassword!";
		WebElement passkey = driver.findElement(By.id("password"));
		passkey.sendKeys(password);
		// click login button
		WebElement button = driver.findElement(By.className("radius"));
		button.click();
		sleep(3000);
		// verification
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String expectedErrorMessage = "Your username is invalid!";
		String currentErrorMessage = errorMessage.getText();
		Assert.assertTrue(currentErrorMessage.contains(expectedErrorMessage), "Message is not same as expected");
		// close browser
		driver.quit();
		
	}
	
	@Test(priority = 2, groups = { "negativeTests" })
	public void incorrectPasswordTest() {
		
		System.out.println("Start Incorrect Login Test");
		// create driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAHUL JAIN\\eclipse-workspace\\selenium-for-java\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// sleep for 3 seconds
		sleep(3000);
		// maximize browser window
		driver.manage().window().maximize();
		// open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");
		sleep(3000);
		// enter the user name
		String username = "tomsmith";
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys(username);
		// enter the password
		String password = "invalidPassword";
		WebElement passkey = driver.findElement(By.id("password"));
		passkey.sendKeys(password);
		// click login button
		WebElement button = driver.findElement(By.className("radius"));
		button.click();
		sleep(3000);
		// verification
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String expectedErrorMessage = "Your password is invalid!";
		String currentErrorMessage = errorMessage.getText();
		Assert.assertTrue(currentErrorMessage.contains(expectedErrorMessage), "Message is not same as expected");
		// close browser
		driver.quit();
		
	}
	
	private void sleep(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
