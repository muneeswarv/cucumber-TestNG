package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
	protected String firstname;
	protected String lastname;
	protected String email;
	
	
	
	
	WebDriver driver = new ChromeDriver();
	@Given("open the signup page using URL")
	public void open_the_signup_page_using_URL() {
		
		
		System.setProperty("webdriver.chrome.driver","C:/Users/AbburiBhavana/Desktop/drivers/chromedriver.exe");
		String baseurl="http://elearningm1.upskills.in/";
		driver.get(baseurl);
		driver.manage().window().maximize();
	    driver.findElement(By.linkText("Sign up!")).click();

		
	}
	
		
	@When("user should enter firstname as {string}")
	public void user_should_enter_firstname_as(String firstname) {
	  driver.findElement(By.id("registration_firstname")).click();
	  WebElement element1 = driver.findElement(By.id("registration_firstname")); 
		element1.sendKeys(firstname);
		this.firstname = firstname;
	}
	@When("user should enter lastname as {string}")
	public void user_should_enter_lastname_as(String lastname) {
		driver.findElement(By.id("registration_lastname")).click();
		  WebElement element2 = driver.findElement(By.id("registration_lastname")); 
			element2.sendKeys(lastname);
			this.lastname = lastname;
			
	}

	
	@When("user should enter email as {string}")
	public void user_should_enter_email_as(String email) {
		driver.findElement(By.id("registration_email")).click();
		  WebElement element2 = driver.findElement(By.id("registration_email")); 
			element2.sendKeys(email);
			this.email=email;
	}
	@When("user should enter username as {string}")
	public void user_should_enter_username_as(String string) {
		driver.findElement(By.id("username")).click();
		  WebElement element3 = driver.findElement(By.id("username")); 
			element3.sendKeys(string);
			
	    }
	@When("user should enter password as {string}")
	public void user_should_enter_password_as(String string) {
		driver.findElement(By.id("pass1")).click();
		  WebElement element4 = driver.findElement(By.id("pass1")); 
			element4.sendKeys(string);
			driver.findElement(By.id("pass2")).click();
			  WebElement element5 = driver.findElement(By.id("pass2")); 
				element5.sendKeys(string);
	}
	
	@When("click on register")
	public void click_on_register() {
		driver.findElement(By.id("registration_submit")).click();
		  
	}
	
	@Then("Registration should be sucessfull")
	public void Registration_should_be_sucessfull() {
		
	    
	    String actualerr1 = driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div/p[1]")).getText();
	   
	    String expected1 = new String("Dear"+" "+this.firstname+" "+this.lastname+",");
	    
	    if(actualerr1.contains(expected1))
	    {
	    System.out.println("registration validation passed");
	    }
	    else
	    	System.out.println(expected1+"failed");
	    
	}
	@Given("validate the email entered")
	public void validate_the_email_entered() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]")).click();
	String actualerr1=driver.findElement(By.xpath("/html/body/main/header/nav/div/div[2]/ul[2]/li[2]/ul/li[1]/div/p")).getText();
		 String expected=email;
		 if(actualerr1.contains(expected))
		 {
			 System.out.println("email validation passed");
		 }
		 else
			 System.out.println(actualerr1);
	}
	@When("user should click on homepage")
	public void user_should_click_on_homepage() {
		driver.findElement(By.className("homepage")).click();
	    
	}
	@And("click on compose")
	public void click_on_compose()
	{
		driver.findElement(By.linkText("Compose")).click();
	}
	@When("user should enter reciever email adress as {string}")
	public void user_should_enter_reciever_email_adress_as(String string) throws InterruptedException {
		driver.findElement(By.className("select2-search__field")).click();
		 WebElement element7 = driver.findElement(By.className("select2-search__field")); 
			element7.sendKeys(string);
			Thread.sleep(9000);
			element7.sendKeys(Keys.ENTER);
	}
	@And("user should enter subject as {string}")
	public void user_should_enter_subject_as(String string)
	{
		driver.findElement(By.id("compose_message_title")).click();
		WebElement element7 = driver.findElement(By.id("compose_message_title")); 
		element7.sendKeys(string);
	}
	@And("user should enter message")
	public void user_should_enter_message()
	{
		driver.findElement(By.id("cke_14")).click();
		WebElement element7 = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, content']")); 
		element7.sendKeys("Hi naveen,\n This is for Testing purpose.\n From\n");
		element7.sendKeys(firstname);
		
		
	}
	@And("user should clikc on sendmessage")
	public void user_should_click_on_sendmessage()
	{
		driver.findElement(By.name("compose")).click();
	}
	@Then ("message should be sent sucessfully")
	public void user_should_be_sent_sucessfully() throws InterruptedException
	{ 
		Thread.sleep(2000);
		String actual=driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div/div[1]")).getText();
		String expected="The message has been sent to";
		
		if(actual.contains(expected))
		{
		System.out.println("message sent sucesful");
	    }
		else
			System.out.println("failed");
		
		driver.quit();
}
	
}
