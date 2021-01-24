package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	public static void main(String[] args) throws InterruptedException {

		googleSearchTest();

	}

	public static void googleSearchTest() throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		GoogleSearchPageObjects gspo = new GoogleSearchPageObjects(driver);

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		gspo.setTextInSearchBox("Automation step by step");
		Thread.sleep(3000);
		gspo.clickSearchButton();

		driver.close();

	}

}
