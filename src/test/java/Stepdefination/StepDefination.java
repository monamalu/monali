package Stepdefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;

@RunWith(Cucumber.class)
public class StepDefination {

	WebDriver driver;
	List<WebElement> webelements;
	private Hook hook;
	
	public StepDefination(Hook hook)
	{
		this.hook = hook;
	}
	
//	@Before
//	public void InitializeTest()
//	{
//		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
//	    driver = new ChromeDriver();
//        
//	}
//	
//	@After
//	public void TearDownTest()
//	{
//		driver.close();
//		driver.quit();
//	}
	

    @Given("^User on landing page$")
    public void user_on_landing_page() throws Throwable {
//    	WebDriver driver = hook.getDriver();
    	driver.get("https://yahoo.com");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String currentUrl =driver.getCurrentUrl();
		Assert.assertEquals("https://www.yahoo.com/", currentUrl);
    }

    @When("^User get list of all the links on the header of home page$")
    public void user_get_list_of_all_the_links_on_the_header_of_home_page() throws Throwable {
	   webelements = driver.findElements(By.xpath("//li[@class='D(ib) Mstart(21px) Mend(17px) Mstart(11px)--sm1024']"));
		System.out.println("Number of web links "+ (webelements.size()));
    }

    @Then("^Get list of all links$")
    public void get_list_of_all_links() throws Throwable {
    	
		for(WebElement ele :webelements )
        {
        	System.out.println(ele.getText());
        }
    }

}

