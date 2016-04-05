package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.w3c.dom.Document;
import commonfunction.CommonFunctions;
import commonfunction.DataProvide;
import commonfunction.DataReader;

/*��¼֮���ϴ��ĵ��������µ�*/

public class Order extends DataProvide {
	
	public CommonFunctions comfun;
	public DataReader dr;
	
  
	@BeforeClass
	public void beforeClass() throws Exception {
		//����ҳ
		String url="http://test2.sui.me/";
		comfun=new CommonFunctions(url);
		dr=new DataReader();
		//��������Դ
		init("src/testdata/Order.xml");
	}
	
	@Test(dataProvider = "Test_xml_dataprovider")
    public void testorder(Document params)throws Exception {
		//��¼
		comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/a");
		comfun.login(dr.readnodevalue(params,"upload","username"), dr.readnodevalue(params,"upload","password"));
		//�л�����ӡҳ��
		comfun.clickitem("xpath", "//*[@id='app']/div/div[1]/nav/ul[1]/li[2]/a");
		//ȡ���ϴ��ؼ�����������
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display=''");
		//�ϴ��ļ�
		comfun.inputvalue("xpath", ".//*[@id='app']/div/div[2]/div[2]/div[1]/div[1]/div/input", dr.readnodevalue(params, "upload", "filepath"));
		((JavascriptExecutor)CommonFunctions.driver).executeScript("var inputs = document.getElementsByTagName('input');inputs[0].style.display='none'");
		Thread.sleep(8000);
		//����
		comfun.clickitem("xpath", ".//*[@id='app']/div/div[2]/div[4]/button");
		//�µ�
		comfun.clickitem("classname", "button-submit");
		Thread.sleep(8000);
		//��֤֧����֧��ҳ��
		comfun.checkequal(comfun.gettext("classname", "logo-title"), "�ҵ�����̨");
		
    }

 
 

    @AfterClass
    public void afterClass()throws Exception {
    	comfun.teardown();
    }

}
