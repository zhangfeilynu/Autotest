package commonfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 数据库操作
 * @author Administrator
 *
 */
public class Dao {
	private Connection conn = null;
	PreparedStatement statement = null;

	public void connSQL() {
		String url = "jdbc:mysql://rdsj4ckkj0pwiiivzw3y5public.mysql.rds.aliyuncs.com:3306/" +
				"wenji_prod_dev?useUnicode=true&amp;characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull"; // 数据库地址，端口，数据库名称，字符集
		String username = "wenji_hzj"; // 数据库用户名
		String password = "jfkdlafdiaelk33"; // 数据库密码
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
			conn = DriverManager.getConnection(url, username, password);
		}
		// 捕获加载驱动程序异常
		catch (ClassNotFoundException cnfex) {
			System.err.println("装载 JDBC/ODBC 驱动程序失败。");
			cnfex.printStackTrace();
		}
		// 捕获连接数据库异常
		catch (SQLException sqlex) {
			System.err.println("无法连接数据库");
			sqlex.printStackTrace();
		}
	}

	// 关闭数据库
	public void deconnSQL() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("关闭数据库异常：");
			e.printStackTrace();
		}
	}

	/**
	 * 执行查询sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 执行插入sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行删除sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean deleteSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("删除数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("删除时出错：");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 执行更新sql语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean updateSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("更新数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("更新时出错：");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 打印结果集
	 * 
	 * 具体列根据自己的数据库表结构更改
	 * 
	 * @param rs
	 */
	public void printres(ResultSet rs) {
		System.out.println("-----------------");
		System.out.println("查询结果:");
		System.out.println("-----------------");
		

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnNumber = rsmd.getColumnCount();
			while(rs.next()){
				for(int i=1;i<=columnNumber;i++){
					if(i>1) System.out.print(", ");
					String columnValue = rs.getString(i);//列值
					System.out.print(rsmd.getColumnName(i)+" "+columnValue);
				}
				System.out.println("");
			}
			/*while (rs.next()) {
				System.out.println(rs.getInt(0) + "/t/t" + rs.getString(1)
						+ "/t/t" + rs.getString(2));
			}*/
		} catch (SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		Dao dao = new Dao();
		dao.connSQL(); // 连接数据库
		String sql1 = "SELECT id,student_id FROM `wenji_print_order` WHERE id=212313882";
		String sql2 = "delete from wenji_print_order where id=212313836";
		String sql3 = "update wenji_print_order set state=5 where id=212313882";

		/*String insert = "insert into users(userID,userName,userPWD) values('10000','10000','10000')";
		String update = "update users set userPWD =20000 where userID= '10000'";
		String delete = "delete from users where userID= '10000'";

		if (dao.insertSQL(insert) == true) {
			System.out.println("插入成功");
			ResultSet resultSet = dao.selectSQL(s);
			dao.print(resultSet);
		}
		if (dao.updateSQL(update) == true) {
			System.out.println("更新成功");
			ResultSet resultSet = dao.selectSQL(s);
			dao.print(resultSet);
		}
		if (dao.insertSQL(delete) == true) {
			System.out.println("删除成功");
			ResultSet resultSet = dao.selectSQL(s);
			dao.print(resultSet);
		}*/
		
		//测试
		ResultSet resultSet = dao.selectSQL(sql1);//查询
		dao.printres(resultSet);
		
		/*if(dao.deleteSQL(sql2)==true){//删除
			System.out.println("删除成功");
		}*/
		
		/*if(dao.updateSQL(sql3)==true){//更新数据
			System.out.println("更新成功");
		}*/
		
		
		
		dao.deconnSQL(); // 关闭数据库连接
	}
}
