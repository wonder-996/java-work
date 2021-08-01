package transform;
import java.util.*;
public class TransformTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("在此输入待转换数字 ：");
        int num = scanner.nextInt();
        System.out.println("请输入想要转换的进制(2/8/16) ：");
        int target = scanner.nextInt();
        //scanner.close();
        System.out.println("转换结果如下： ");
        Transfrm m = new Transfrm(num, target);
        m.changeNum();
	}

}
