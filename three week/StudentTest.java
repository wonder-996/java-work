package student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentTest {
	private static StudentAdd db=new StudentAdd();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*********************************");
		System.out.println("*\t\t\t\t*");
		System.out.println("*\t欢迎使用学生信息管理系统\t*");
		System.out.println("*\t\t\t\t*");
		System.out.println("*********************************");
		int option=0;
		do {
			menu();
			System.out.println("是否继续：");
			Scanner in = new Scanner(System.in);
			int option1  = in.nextInt();
			option=option1;
		}while(option>=1&&option<=4);
		System.out.println("再见！！！");
	}
	static void menu() {
		System.out.println("1、添加学生信息");
		System.out.println("2、删除学生信息");
		System.out.println("3、修改学生信息");//地址传递
		System.out.println("4、查询学生信息(分数不及格，180以下)");//name
		System.out.println("请输入操作，以Enter键结束:");
		Scanner scanner = new Scanner(System.in);
		int option  = scanner.nextInt();
		switch (option) {
			case 1:{
				
				System.out.println("请输入学号：");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(db.exist(sql)) {//通过exist方法判断学号是否已存在
					System.out.println("学号已存在！");
					return;
				}
				System.out.println("请输入姓名：");
				String name=scanner.next();
				System.out.println("请输入成绩：");
			 int  chinese=scanner.nextInt();
			 int  math=scanner.nextInt();
			 int  english=scanner.nextInt();
				sql="insert into student(num,name,chinese_grade,math_grade,english_grade) values ('"+id+"','"+name+"','"+chinese+"','"+math+"','"+english+"')";
				if(db.update(sql)) {
					System.out .println("添加成功！");
					return;
				}
				System.out .println("添加失败！");
				break;
			}
			case 2:{
				System.out.println("请输入学号：");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("学号不存在！");
					return;
				}
				
				sql="delete from student where num='"+id+"'";
				if(db.update(sql)) {
					System.out.println("删除成功！");
					return;
				}
				System.out .println("删除失败！");
				break;
			}
			case 3:{
				System.out.println("请输入学号：");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("学号不存在！");
					return;
				}
				
				System.out.println("请输入新姓名：");
				String name=scanner.next();
				
				System.out.println("请输入成绩：");
				 int  chinese=scanner.nextInt();
				 int  math=scanner.nextInt();
				 int  english=scanner.nextInt();
				
				sql="update student set name='"+name+"',chinese_grade='"+chinese+"',math_grade='"+math+"',english_grade='"+english+"' where num='"+id+"'";
				if(db.update(sql)) {
					System.out.println("修改成功！");
					return;
				}
				System.out .println("修改失败！");
				break;
			}
			case 4:{
				/*System.out.println("请输入学号：");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("学号不存在！");
					return;
				}*/
				
				String sql = "select num,name,chinese_grade,math_grade,english_grade from student where chinese_grade+math_grade+english_grade<='"+180+"'";
				class RowMapper implements IRowMapper{//实现IRowMapper接口
					public void rowmapper(ResultSet rs) {
try {
							if(rs.next()) {
						        String id = rs.getString("num");
						        String name = rs.getString("name");
						        int  chinese=rs.getInt("chinese_grade");
								 int  math=rs.getInt("math_grade");
								 int  english=rs.getInt("english_grade");
						        System.out.println(id+","+name+","+chinese+","+math+","+english);
						      }
						}catch (SQLException e) {
						      e.printStackTrace();
					    }
					}
				}
				db.select(sql, new RowMapper());
			
				break;
			}
			default:
				System.out.println("I'm Sorry,there is not the "+option+" option,please try again.");break;
		}
	}
}

