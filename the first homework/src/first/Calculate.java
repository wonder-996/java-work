package first;
import java.util.*;
public class Calculate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in =new Scanner(System.in);
System.out.println("输入表达式：");
double first=in.nextDouble();
char Fu=in.next().charAt(0);
double second=in.nextDouble();
Jisuan ha=new Jisuan(Fu,first,second);
System.out.println("计算结果为："+ ha.calculate());

	}

}
class Jisuan{
	private char fu;
	private double m;
	private double n;
	Jisuan(char a,double b,double c){fu=a;m=b;n=c;}
	public double calculate()
	{if(fu=='+')return m+n;
	else if(fu=='-')return m-n;
	else if(fu=='*')return m*n;
	else return m/n;}
}