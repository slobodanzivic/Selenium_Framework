package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;

public class TestNG_Demo2 {

	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		driver = new ChromeDriver();

	}

	@Test
	public void googleSearchTest2() throws InterruptedException {

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		GoogleSearchPageObjects gspo = new GoogleSearchPageObjects(driver);
		gspo.setTextInSearchBox("Automation step by step");
		Thread.sleep(3000);
		gspo.clickSearchButton();

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		System.out.println("Test is successfully completed");
	}

}
