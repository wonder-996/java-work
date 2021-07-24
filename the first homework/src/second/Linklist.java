package second;


public class Linklist {
   private Node head;
   private int length = 0;

   public Linklist() {
       this.head = null;
   }

   //在链表头部添加结点
   public void addHead(int data) {
       Node newNode = new Node(data);
       newNode.setNext(newNode);
       newNode.setPrevious(newNode);
       if(head == null){
           head = newNode;
       } else{
           Node curNode = head;
           while(curNode.getNext() != head) {
               curNode = curNode.getNext();
           }
           newNode.setNext(head);
           curNode.setNext(newNode);
           newNode.setPrevious(curNode);
           head.setPrevious(newNode);
           head = newNode;
       }
       length++;
   }

   //在链表头部删除结点
   public void deleteHead() {
       if(head == null){
           System.out.println("空表，删除的结点不存在");
       }
       Node curNode = head;
       while(curNode.getNext() != head) {
           curNode = curNode.getNext();
       }
       Node temp =head.getNext();
       curNode.setNext(temp);
       temp.setPrevious(curNode);
       head =temp;
       length--;
   }

   
   //在链表尾部删除结点
   public void deleteTail() {
       if(head == null){
           System.out.println("空表，删除的结点不存在");
       }
       Node curNode = head;
       Node preNode =head;
       while(curNode.getNext() != head) {
           preNode = curNode;
           curNode = curNode.getNext();
       }
       preNode.setNext(head);
       head.setPrevious(preNode);
       curNode = null;
       length--;
   }

   //在指定位置插入结点
   public void insertList(int data, int index) {
       Node newNode = new Node(data);
       newNode.setNext(newNode);
       newNode.setPrevious(newNode);
       if(head == null){
           head = newNode;
       }
       if(index > length+1 || index < 1) {
           System.out.println("结点插入的位置不存在，可插入的位置为1到"+(length+1));
       }else if(index == 1) {
           Node curNode = head;
           while(curNode.getNext() != head) {
               curNode = curNode.getNext();
           }
           newNode.setNext(head);
           curNode.setNext(newNode);
           newNode.setPrevious(curNode);
           head.setPrevious(newNode);
           head = newNode;
       } else{
           Node preNode = head;
           int count = 1;
           while(count < index-1) {
               preNode = preNode.getNext();
               count++;
           }
           Node curNode = preNode.getNext();
           newNode.setNext(curNode);
           curNode.setPrevious(newNode);
           preNode.setNext(newNode);
           newNode.setPrevious(preNode);
       }
       length++;
   }

   //在指定位置删除结点
   public void deleteList(int index) {
       if(index > length || index < 1) {
           System.out.println("结点删除的位置不存在，可删除的位置为1到"+length);
       }else if(index == 1) {
           Node curNode = head;
           while(curNode.getNext() != head) {
               curNode = curNode.getNext();
           }
           Node temp =head.getNext();
           curNode.setNext(temp);
           temp.setPrevious(curNode);
           head =temp;
           length--;
       } else{
           Node preNode = head;
           int count = 1;
           while(count < index-1) {
               preNode = preNode.getNext();
               count++;
           }
           Node curNode = preNode.getNext();
           Node laterNode = curNode.getNext();
           preNode.setNext(laterNode);
           laterNode.setPrevious(preNode);
           length--;
       }
   }
   //获取指定位置的数据
   public void getIndexData(int index) {
       if(head == null){
           System.out.println("空表");
       }
       if(index > length || index < 1) {
           System.out.println("结点位置不存在，可获取的位置为1到"+length);
       }else {
           Node curNode = head;
           int count =1;
           while(count != index) {
               curNode =curNode.getNext();
               count++;
           }
           curNode.display();
           System.out.println();
       }
   }

   //修改指定位置的结点数据
   public void updateIndexData(int index, int data) {
       if(head == null){
           System.out.println("空表");
       }
       if(index > length || index < 1) {
           System.out.println("结点位置不存在，可更新的位置为1到"+length);
       }else {
           Node curNode = head;
           int count =1;//while也可以用for循环方式解决
           while(count != index) {
               curNode =curNode.getNext();
               count++;
           }
           curNode.setData(data);
       }
   }

   //获取链表的长度
   public int  listLength() {
       return length;
   }

   //正向遍历链表
   public void printOrderNode() {
       if(head == null) {
           System.out.println("空表");
       }
       Node cur = head;
       while (cur != null) {
           cur.display();
           cur = cur.getNext();
           if(cur == head) {
               break;
           }
       }
       System.out.println();
   }

}