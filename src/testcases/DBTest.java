package testcases;

import java.sql.ResultSet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import commonfunction.CommonFunctions;
import commonfunction.Dao;

public class DBTest extends CommonFunctions {
  private Dao dao = new Dao();
  @BeforeClass
  public void beforeClass() {
	  
	  dao.connSQL();//连接数据库
  }
  
  @Test
  public void dbtest() {
	  //String sql1 = "SELECT id,student_id FROM `wenji_print_order` WHERE id=212313882";
	  String sql1 = "SELECT * FROM `wenji_print_order` WHERE id=212313882";
	  String sql2 = "delete from wenji_student where id=9999";
	  ResultSet resultSet = dao.selectSQL(sql1);//查询
	  dao.printres(resultSet);
	  /*if(dao.deleteSQL(sql2)==true){
		  System.out.println("删除成功");
	  }*/
  }

  @AfterClass
  public void afterClass() {
  }

}
