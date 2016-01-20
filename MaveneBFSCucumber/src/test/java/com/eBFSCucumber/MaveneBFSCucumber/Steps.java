package com.eBFSCucumber.MaveneBFSCucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^Navigate to eBFS site$")
	public void NavigatetoeBFSsite() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Click on SignIn link$")
	public void ClickonSignInlink() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Then("^Input Invalid email address under create an account$")
	public void InputInvalidemailaddressundercreateanaccount() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("Invalid@Email");
	}

	@And("^Click on Create an account button$")
	public void ClickonCreateanaccountbutton() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
	}

	@And("^Close browser$")
	public void Closebrowser() throws Throwable {
		driver.quit();
	}

	@Then("^Input Alredy Registered email address under create an account$")
	public void InputAlredyRegisteredemailaddressundercreateanaccount() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("mizan@gmail.com");
	}

	@Then("^Input New email address under create an account$")
	public void InputNewemaiundercreateanaccount() throws Throwable {
		driver.findElement(By.id("email_create")).sendKeys("tpumqoazan@gmail.com");
	}

	@Then("^Click on Create an New account button$")
	public void ClickonCreateanNewaccountbutton(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();

		driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys(data.get(1).get(1));
		driver.findElement(By.name("customer_lastname")).sendKeys(data.get(2).get(1));
		driver.findElement(By.name("passwd")).sendKeys(data.get(3).get(1));
		driver.findElement(By.name("days")).sendKeys(data.get(4).get(1));
		driver.findElement(By.name("months")).sendKeys(data.get(5).get(1));
		driver.findElement(By.name("years")).sendKeys(data.get(6).get(1));

	}

	@Then("^Click on Register$")
	public void ClickonRegister() throws Throwable {
		driver.findElement(By.name("submitAccount")).click();
	}

	@Then("^Click on Personal Link$")
	public void ClickonPersonalLink(DataTable table1) throws Throwable {
		List<List<String>> data1 = table1.raw();
		driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[5]/a/span")).click();
		driver.findElement(By.name("lastname")).sendKeys(data1.get(1).get(1));
		driver.findElement(By.name("old_passwd")).sendKeys(data1.get(2).get(1));
		driver.findElement(By.name("passwd")).sendKeys(data1.get(3).get(1));
		driver.findElement(By.name("confirmation")).sendKeys(data1.get(4).get(1));
	}

	@Then("^Click on save$")
	public void Clickonsave() throws Throwable {
		driver.findElement(By.name("submitIdentity")).click();
	}

	@When("^Input Shirt in search field$")
	public void InputShirtinsearchfield() throws Throwable {
		driver.findElement(By.name("search_query")).sendKeys("Shirt");
	}

	@Then("^Click on searh button$")
	public void Clickonsearhbutton() throws Throwable {
		driver.findElement(By.name("submit_search")).click();
	}

	@Then("^Validate Top Seller Product in left side$")
	public void ValidateTopSellerProductinleftside() throws Throwable {
	 Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='best-sellers_block_right']/h4")).isDisplayed());
		
	}
	@When("^Hover over mouse on any product & 'Quick View' Button$")
	public void HoverovermouseonanyproductQuickViewButton() throws Throwable {
		Actions builder=new Actions(driver);
	WebElement prod=driver.findElement(By.xpath(".//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img"));
		builder.moveToElement(prod).perform();
	WebElement more=driver.findElement(By.xpath(".//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[2]/span"));
	builder.click(more).build().perform();	
	}

	@Then("^Change product quantity & Change size$")
	public void ChangeproductquantityChange_size() throws Throwable {
		Actions builder=new Actions(driver);
		WebElement quantity= driver.findElement(By.xpath(".//*[@id='quantity_wanted_p']/a[2]/span/i"));  
	builder.doubleClick(quantity).build().perform();
	driver.findElement(By.xpath(".//*[@id='group_1']")).sendKeys("L");
	}

	@And("^Click 'Add to Cart' button$")
	public void ClickAddtoCartbutton() throws Throwable {
	   driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).click();
	}

	@And("^Click 'Proceed to checkout button'$")
	public void ClickProceedtocheckoutbutton() throws Throwable {
	   driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
	}
}