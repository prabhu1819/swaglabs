package stepdefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class swag 
{

	public WebDriver d;
	
	@Given("^User is on the login page$")
    public void user_is_on_the_login_page() 
	{
        System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Desktop\\Jeet\\jeet1\\drivers\\msedgedriver.exe");
        //EdgeOptions e = new EdgeOptions();
        //e.addArguments("--headless");
        d = new EdgeDriver();
        d.navigate().to("https://www.saucedemo.com");
        d.manage().window().maximize();
        
    }

    @When("^User enters the Valid (.+) and (.+)$")
    public void user_enters_the_valid_and(String username, String password)
    {
      d.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
      d.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() 
    {
      d.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    
    @Then("^User navigates to the Homepage$")
    public void user_navigates_to_the_homepage() 
    {
      String title = d.getTitle();
      System.out.println("Title of the page is:"+title);
    }


    @And("^User applies the filter and selects the products and add to cart$")
    public void user_applies_the_filter_and_selects_the_products_and_add_to_cart() 
    {
      d.findElement(By.xpath("//select[contains(@class,'sort_container')]")).click();
      d.findElement(By.xpath("//option[@value='lohi']")).click();
      d.findElement(By.xpath("//button[contains(@id,'onesi')]")).click();
    }
    @Then("^User moves to cart and clicks on continue shopping and user navigates to the home page$")
    public void user_moves_to_cart_and_clicks_on_continue_shopping_and_user_navigates_to_the_home_page() 
    {
        d.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
        d.findElement(By.xpath("//button[@id='continue-shopping']")).click();
        String exp = "Swag Labs";
        String act = d.getTitle();
        SoftAssert s = new SoftAssert();
        s.assertEquals(act, exp);
        s.assertAll();
    }
    @And("^User selects another product and moves to cart$")
    public void user_selects_another_product_and_moves_to_cart() 
    {
       d.findElement(By.xpath("//button[contains(@id,'labs-bike-light')]")).click();
    }
    
    @When("^user clciks on checkout Add info form opens and user fills the (.+) (.+) and (.+)$")
    public void user_clciks_on_checkout_add_info_form_opens_and_user_fills_the_and(String firstname, String lastname, String zipcode) throws IOException 
    {
    	
    	
    	d.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
    	d.findElement(By.xpath("//button[@id='checkout']")).click();
        d.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
        d.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
        d.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(zipcode);
    	
    	
    }
    @And("^User clicks on continue and invoice is generated$")
    public void user_clicks_on_continue_and_invoice_is_generated() 
    {
        d.findElement(By.xpath("//input[@id='continue']")).click();
        String tit = d.getTitle();
        System.out.println(tit);
    }
    @Then("^User clicks on finish and logs out$")
    public void user_clicks_on_finish_and_logs_out() 
    {
    	d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      d.findElement(By.xpath("//button[@id='finish']")).click();
      d.findElement(By.xpath("//div[@class='bm-burger-button']")).click();
      d.findElement(By.xpath("//a[text()='Logout']")).click();
      String title = d.getTitle();
      System.out.println(title);
    }
    @After(order = 1)
	public void takescreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot s = (TakesScreenshot)d;
			byte[] src = s.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "imag/png", "screenshot");
			
		}
	}
	
}
