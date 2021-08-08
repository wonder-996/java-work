package student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StudentAdd {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			String url = "jdbc:mysql://localhost:3306/student_system?";
			return DriverManager.getConnection(url, "root", "123456");//获取连接
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public void select(String sql,IRowMapper rowMapper) {//接口无法创建对象，rowMapper一定指向IRowMapper的实现类对象
	    Connection connection = null;
	    Statement statement =null;
	    ResultSet resultSet=null;
	    try {
	      connection=getConnection();
	      statement = connection.createStatement();
	      resultSet= statement.executeQuery(sql);//执行sql,将查询的数据存到ResultSet类型的变量中
	      rowMapper.rowmapper(resultSet);//调用接口实现类的rowmapper方法
	    } catch (Exception e) {
	      e.printStackTrace();
	    }finally {
	      close(resultSet,statement,connection);
	    }
	  }
	
	public boolean update(String sql) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=getConnection();
			statement=connection.createStatement();
			int result=statement.executeUpdate(sql);
			//statement.close();
			//connection.close();
			return result>0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(statement,connection);
		}
		return false;
	}
	
	private void close(Statement statement,Connection connection) {
		try {
			if(statement!=null) {
				statement.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection!=null) {
				connection.close();
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean exist(String sql) {
	    Connection connection = null;
	    Statement statement =null;
	    ResultSet resultSet=null;
	    try {
	        connection = getConnection();//获取连接
	        statement = connection.createStatement();
	        resultSet= statement.executeQuery(sql);//执行sql,将查询的数据存到ResultSet类型的变量中
	        return resultSet.next();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }finally {
	    	close(resultSet,statement,connection);
	    }
	    return false;
	 }
	
	private void close(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement!=null) {
				statement.close();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection!=null) {
				connection.close();
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
 interface IRowMapper {
	void rowmapper (ResultSet rs);
}