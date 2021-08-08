package linklist;
import java.util.*;
public class LinkList {public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        deleteNode(listNode.next);
       while(listNode!=null) {System.out.println(listNode.val);listNode=listNode.next;}
       
}
public static void deleteNode(ListNode pNode) {
	if(pNode==null)return;
	pNode.val=pNode.next.val;
	pNode.next=pNode.next.next;
}
}
class ListNode {
    int val;
    ListNode next;   
    ListNode(int x) { val = x; }
    
}