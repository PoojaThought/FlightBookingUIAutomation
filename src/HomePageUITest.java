import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePageUITest 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Static dropdown
		WebElement eleStaticDD = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
		Select s = new Select(eleStaticDD);
		s.selectByIndex(3);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("AED");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement eleDDPlus = driver.findElement(By.id("hrefIncAdt"));
		for(int i=0;i<3;i++)
			eleDDPlus.click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());	
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> countryOptions = driver.findElements(By.cssSelector("li.ui-menu-item a"));
		for(WebElement countryOption:countryOptions)
		{
			if(countryOption.getText().equalsIgnoreCase("india"))
			{
				countryOption.click();
				break;
			}
		}
		
	}

}
