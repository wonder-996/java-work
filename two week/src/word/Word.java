package word;
import java.util.*;
public class Word {

	public static void main(String[] args) {
	Scanner word=new Scanner(System.in);
	System.out.println("输入句子A：");
	String A=word.nextLine();
	System.out.println("输入句子B：");
	String B=word.nextLine();
	System.out.println(A+B);
	unwords(A,B);
	}

    public static void unwords(String A, String B) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    for(String word : A.split(" ")){
        if(map.containsKey(word)){
        map.put(word, false);
        }else{
        map.put(word, true);
        }
    }
    for(String word : B.split(" ")){
        if(map.containsKey(word)){
        map.put(word, false);
        }else{
        map.put(word, true);
        }
    }
    ArrayList<String> ans = new ArrayList<String>();
    for(String word : map.keySet()){
        if(map.get(word)){
        ans.add(word);
        }
    }
System.out.println (ans);
    }
}