package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsDemo {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// start reporters
		ExtentReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("GoogleSearchTest", "This test is verify search functionality");

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		driver = new ChromeDriver();

		test.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test.pass("Navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Selenium");
		test.pass("Entered text in the textbox");

		Thread.sleep(3000);

		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("Pressed keyboard enter");

		driver.close();
		driver.quit();
		test.pass("Closed the browser");

		test.info("Test completed");

		// calling flush writes everything to the log file
		extent.flush();
	}
}
