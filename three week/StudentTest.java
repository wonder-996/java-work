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
		System.out.println("*\t��ӭʹ��ѧ����Ϣ����ϵͳ\t*");
		System.out.println("*\t\t\t\t*");
		System.out.println("*********************************");
		int option=0;
		do {
			menu();
			System.out.println("�Ƿ������");
			Scanner in = new Scanner(System.in);
			int option1  = in.nextInt();
			option=option1;
		}while(option>=1&&option<=4);
		System.out.println("�ټ�������");
	}
	static void menu() {
		System.out.println("1�����ѧ����Ϣ");
		System.out.println("2��ɾ��ѧ����Ϣ");
		System.out.println("3���޸�ѧ����Ϣ");//��ַ����
		System.out.println("4����ѯѧ����Ϣ(����������180����)");//name
		System.out.println("�������������Enter������:");
		Scanner scanner = new Scanner(System.in);
		int option  = scanner.nextInt();
		switch (option) {
			case 1:{
				
				System.out.println("������ѧ�ţ�");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(db.exist(sql)) {//ͨ��exist�����ж�ѧ���Ƿ��Ѵ���
					System.out.println("ѧ���Ѵ��ڣ�");
					return;
				}
				System.out.println("������������");
				String name=scanner.next();
				System.out.println("������ɼ���");
			 int  chinese=scanner.nextInt();
			 int  math=scanner.nextInt();
			 int  english=scanner.nextInt();
				sql="insert into student(num,name,chinese_grade,math_grade,english_grade) values ('"+id+"','"+name+"','"+chinese+"','"+math+"','"+english+"')";
				if(db.update(sql)) {
					System.out .println("��ӳɹ���");
					return;
				}
				System.out .println("���ʧ�ܣ�");
				break;
			}
			case 2:{
				System.out.println("������ѧ�ţ�");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("ѧ�Ų����ڣ�");
					return;
				}
				
				sql="delete from student where num='"+id+"'";
				if(db.update(sql)) {
					System.out.println("ɾ���ɹ���");
					return;
				}
				System.out .println("ɾ��ʧ�ܣ�");
				break;
			}
			case 3:{
				System.out.println("������ѧ�ţ�");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("ѧ�Ų����ڣ�");
					return;
				}
				
				System.out.println("��������������");
				String name=scanner.next();
				
				System.out.println("������ɼ���");
				 int  chinese=scanner.nextInt();
				 int  math=scanner.nextInt();
				 int  english=scanner.nextInt();
				
				sql="update student set name='"+name+"',chinese_grade='"+chinese+"',math_grade='"+math+"',english_grade='"+english+"' where num='"+id+"'";
				if(db.update(sql)) {
					System.out.println("�޸ĳɹ���");
					return;
				}
				System.out .println("�޸�ʧ�ܣ�");
				break;
			}
			case 4:{
				/*System.out.println("������ѧ�ţ�");
				String id=scanner.next();
				String sql="select name from student where num='"+id+"'";
				if(!db.exist(sql)) {
					System.out.println("ѧ�Ų����ڣ�");
					return;
				}*/
				
				String sql = "select num,name,chinese_grade,math_grade,english_grade from student where chinese_grade+math_grade+english_grade<='"+180+"'";
				class RowMapper implements IRowMapper{//ʵ��IRowMapper�ӿ�
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

