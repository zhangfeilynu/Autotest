package commonfunction;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 截图类
 * @author Administrator
 *
 */
public class ScreenShot {
	public WebDriver driver;    
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }
 
    public void takeScreenshot(String screenPath) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error: " + screenPath);
        }    	    	
    }
 
    public void takeScreenshot() {
    	String dateStr = String.valueOf(new Date().getTime());
        //String screenName = dateStr +driver.getTitle()+ ".jpg";
    	String screenName = dateStr + ".jpg";
    	File dir = new File("test-output/snapshot");
        if (!dir.exists())
            dir.mkdirs();
        String screenPath = dir.getAbsolutePath() + "/" + screenName;
        this.takeScreenshot(screenPath); 
        System.out.println("截图是："+screenName);
    }
}
