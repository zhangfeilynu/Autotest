package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;


public class LoginDemo {
  private WebDriver driver;
  private String baseUrl;
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = new FirefoxDriver();
	  baseUrl="http://test2.sui.me";
  }
  
  @Test
  public void testlogin() throws Exception{
      
      driver.get(baseUrl);
      Thread.sleep(2000);
      driver.manage().window().maximize();
      driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a")).click();
      driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/input")).sendKeys("15261672979");
      driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[3]/input")).sendKeys("123");
      driver.findElement(By.className("col-md-6")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id='app']/div/div[1]/nav/ul[1]/li[2]/a")).click();
      ((JavascriptExecutor)driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
      String filepath="F:\\Linux_tail.doc"; 
      driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys(filepath);
      ((JavascriptExecutor)driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
      Thread.sleep(2000);
	  driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/div[4]/button")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.className("button-submit")).click();
	  Thread.sleep(5000);
	  String title=driver.findElement(By.className("logo-title")).getText();
	  assertEquals(title,"我的收银台");
	

}
  

  @AfterTest
  public void afterTest() {
	  
	 driver.quit();
	 
  }

}
