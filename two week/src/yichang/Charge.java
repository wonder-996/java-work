package yichang;

public class Charge {
public void check(int n) throws Yichang{
	if(n>-2147483648&&n<2147483647) {n++;System.out.println("×ÔÔö");}
	else throw new Yichang();
}
}
