package yichang;
import java.util.*;
public class ChargeTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("ÇëÊäÈëÊı×Ö£º");
		int number=in.nextInt();
		Charge t=new Charge();
		try {t.check(number);}
		catch(Yichang e) {e.printStackTrace();}

}}
