package commonfunction;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import commonfunction.ScreenShot;
/**
 * 监听错误，重写onTestFailure方法
 * @author Administrator
 *
 */
public class DotTestListener extends TestListenerAdapter {
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		try {
            CommonFunctions cf = (CommonFunctions) tr.getInstance();
            WebDriver driver = cf.getDriver();
            ScreenShot dr= new ScreenShot(driver);
            dr.takeScreenshot();            
            //System.out.println(driver.getTitle());
            //System.out.println(String.valueOf(new Date().getTime())+driver.getTitle());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {         
            e.printStackTrace();
        }
		
    }

}
