package third;
import java.util.*;
public class Clock {
public static void main(String[] args) {
Scanner in=new Scanner(System.in);
System.out.println("输入当前时间：");
int m=in.nextInt();
int n=in.nextInt();
int p=in.nextInt();
int q=in.nextInt();
char w=in.next().charAt(0);
int s=in.nextInt();
char g=in.next().charAt(0);
int h=in.nextInt();
Time now=new Time(m,n,p,q,s,h);
now.increase();
}
}
class Time{
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	Time(int a,int b,int c,int d,int e,int f){year=a;month=b;day=c;hour=d;minute=e;second=f;}
	public void increase() {
		try{while(true) {second++;if(second==60) {second=0;minute++;}
		if(minute==60) {minute=0;hour++;}
		if(hour==24) {hour=0;day++;}
		if(day==30) {day=1;month++;}
		if(month==12) {month=1;year++;}
		System.out.println(year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second);
		Thread.sleep(1000);}}catch(InterruptedException ex) {System.out.println("出现异常");}
		
	}
}