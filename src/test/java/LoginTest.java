import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{

	static WebDriver driver;

	String url = "https://github.com/login";

	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver\\win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test
	public void test()
	{
		WebElement element = driver.findElement(By.name("login"));
		element.sendKeys("login");
		assertEquals("login", element.getAttribute("value"));
		element = driver.findElement(By.name("password"));
		element.sendKeys("pass");
		assertEquals("pass", element.getAttribute("value"));
		// driver.findElement(By.name("commit")).click();
	}

	@AfterClass
	public static void tearDownAfterClass() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
