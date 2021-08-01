package listtest;
public class Listtest {public static void main(String[] args) {
		ListNode list=new ListNode(1);
		list.next=new ListNode(2);
	list.next.next=new ListNode(3);
	System.out.println("head="+reverseList(list).val);
	
	}
public static ListNode reverseList(ListNode head) {
    ListNode pre=null;
    ListNode cur=head;
    ListNode temp=null;
    while(cur!=null){
        temp=cur.next;
        cur.next=pre;
        pre=cur;
        cur=temp;
    }
    return pre;

}
}
 class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
       val = x;
   }
}
