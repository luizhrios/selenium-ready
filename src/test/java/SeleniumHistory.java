import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHistory
{

	static WebDriver driver;

	WebElement element, senha;

	@Given("que eu estiver na pagina do https://www.phptravels.net/")
	public void noSite()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver\\\\win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/login");
	}

	@When("o campo login e password estiver em branco")
	public void campoLoginBranco()
	{
		element = driver.findElement(By.name("username"));
		senha = driver.findElement(By.name("password"));
	}

	@Then("preencha com os dados do usuario")
	public void preenche() throws InterruptedException
	{
		element.sendKeys("jose@fuckmail.com");
		senha.sendKeys("1234567");
		Assert.assertEquals("jose@fuckmail.com", element.getAttribute("value"));
		driver.findElement(By.className("loginbtn")).click();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}