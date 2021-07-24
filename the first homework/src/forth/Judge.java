package forth;
import java.util.*;
public class Judge {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String all=new String("acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi");
String[] ar=all.split(",");
int k=0,v,i;

System.out.println("分割后的字符串为：");
for(String a:ar) {System.out.println(a);k++;}
for(i=0;i<k;i++) {
	char []h=ar[i].toCharArray();
	Sentence a=new Sentence(h,ar[i].length());
	System.out.println("第"+(i+1)+"个字符串是否为大写："+a.big());}
}}
class Sentence{
	private char[] m;
	private int n;
	Sentence(char[] A,int a){m=A;n=a;}
	public boolean number() {
		int i=0;
		while(m[i]>=0&&m[i]<=9) {i++;if(i==n) {return true;}}
		
		 return false;	}
	public boolean big() {
         int	c=0;	
             while(m[c]>='A'&&m[c]<='Z') {c++;if(c==n)return true;}
             
        return false;
             }
      public boolean small() {int b=0;
    while(m[b]>='a'&&m[b]<='z') {b++;if(b==n)return true;}
     return false;}
      public void stob() {int i=0;while((m[i]>='a'&&m[i]<='z')||(m[i]>='A'&&m[i]<='Z')) {i++;if(i==n) {for(i=0;i<n;i++) {
    	  if(m[i]>='a'&&m[i]<='z')m[i]=(char) (m[i]-32);}
      
      }}}
public void sort() {int i=0,j,temp=0,min;while(m[i]>=0&&m[i]<=9) {i++;if(i==n) {for(i=0;i<n-1;i++)
{min=i;
	for(j=1;j<n;j++)
		{if(m[j]<m[min])min=j;
		}if(i!=min) {temp=m[min];
		m[min]=m[i];
		m[i]=(char) temp;}}}

for(i=0;i<n;i++)System.out.print(m[i]+"  ");
}}
public void string() {int i=0,j,min=0,temp;while((m[i]>='a'&&m[i]<='z')||(m[i]>='A'&&m[i]<='Z')) {i++;if(i==n) {for(i=0;i<n-1;i++) {min=i;
for(j=1;j<n;j++)
	{if(m[j]<m[min])min=j;
	}
if(min!=i) {temp=m[min];
m[min]=m[i];
m[i]=(char) temp;}}
for(i=0;i<n;i++)
	System.out.print(m[i]+"  ");}}}

}