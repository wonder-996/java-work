package transform;
import java.util.*;
public class TransformTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("�ڴ������ת������ ��");
        int num = scanner.nextInt();
        System.out.println("��������Ҫת���Ľ���(2/8/16) ��");
        int target = scanner.nextInt();
        //scanner.close();
        System.out.println("ת��������£� ");
        Transfrm m = new Transfrm(num, target);
        m.changeNum();
	}

}
