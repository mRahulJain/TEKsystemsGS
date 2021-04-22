package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTestChrome() {

		System.out.println("Start Login Test");
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
		String password = "SuperSecretPassword!";
		WebElement passkey = driver.findElement(By.id("password"));
		passkey.sendKeys(password);
		// click login button
		WebElement button = driver.findElement(By.className("radius"));
		button.click();
		sleep(3000);
		// verifications with the new URL
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual Page URL is not the same as expected");
		// check logout button is visible
		WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout Button is not visible");
		// successful login message
		WebElement successMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
//		Assert.assertEquals(actualMessage, expectedMessage, "Not same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Not same as expected");
		System.out.println("Logged In successfully");
		// close browser
		driver.quit();
	}

	@Test
	public void loginTestEdge() throws InterruptedException {

		System.out.println("Start Login Test");
		// create driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\RAHUL JAIN\\eclipse-workspace\\selenium-for-java\\src\\main\\resources\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
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
		String password = "SuperSecretPassword!";
		WebElement passkey = driver.findElement(By.id("password"));
		passkey.sendKeys(password);
		// click login button
		WebElement button = driver.findElement(By.className("radius"));
		button.click();
		sleep(3000);
		// verifications with the new URL
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual Page URL is not the same as expected");
		// check logout button is visible
		WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout Button is not visible");
		// successful login message
		WebElement successMessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
//		Assert.assertEquals(actualMessage, expectedMessage, "Not same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Not same as expected");
		System.out.println("Logged In successfully");
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
