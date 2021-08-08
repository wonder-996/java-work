package student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StudentAdd {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//��������
			String url = "jdbc:mysql://localhost:3306/student_system?";
			return DriverManager.getConnection(url, "root", "123456");//��ȡ����
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public void select(String sql,IRowMapper rowMapper) {//�ӿ��޷���������rowMapperһ��ָ��IRowMapper��ʵ�������
	    Connection connection = null;
	    Statement statement =null;
	    ResultSet resultSet=null;
	    try {
	      connection=getConnection();
	      statement = connection.createStatement();
	      resultSet= statement.executeQuery(sql);//ִ��sql,����ѯ�����ݴ浽ResultSet���͵ı�����
	      rowMapper.rowmapper(resultSet);//���ýӿ�ʵ�����rowmapper����
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
	        connection = getConnection();//��ȡ����
	        statement = connection.createStatement();
	        resultSet= statement.executeQuery(sql);//ִ��sql,����ѯ�����ݴ浽ResultSet���͵ı�����
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