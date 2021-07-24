package second;


public class Linklist {
   private Node head;
   private int length = 0;

   public Linklist() {
       this.head = null;
   }

   //������ͷ����ӽ��
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

   //������ͷ��ɾ�����
   public void deleteHead() {
       if(head == null){
           System.out.println("�ձ�ɾ���Ľ�㲻����");
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

   
   //������β��ɾ�����
   public void deleteTail() {
       if(head == null){
           System.out.println("�ձ�ɾ���Ľ�㲻����");
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

   //��ָ��λ�ò�����
   public void insertList(int data, int index) {
       Node newNode = new Node(data);
       newNode.setNext(newNode);
       newNode.setPrevious(newNode);
       if(head == null){
           head = newNode;
       }
       if(index > length+1 || index < 1) {
           System.out.println("�������λ�ò����ڣ��ɲ����λ��Ϊ1��"+(length+1));
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

   //��ָ��λ��ɾ�����
   public void deleteList(int index) {
       if(index > length || index < 1) {
           System.out.println("���ɾ����λ�ò����ڣ���ɾ����λ��Ϊ1��"+length);
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
   //��ȡָ��λ�õ�����
   public void getIndexData(int index) {
       if(head == null){
           System.out.println("�ձ�");
       }
       if(index > length || index < 1) {
           System.out.println("���λ�ò����ڣ��ɻ�ȡ��λ��Ϊ1��"+length);
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

   //�޸�ָ��λ�õĽ������
   public void updateIndexData(int index, int data) {
       if(head == null){
           System.out.println("�ձ�");
       }
       if(index > length || index < 1) {
           System.out.println("���λ�ò����ڣ��ɸ��µ�λ��Ϊ1��"+length);
       }else {
           Node curNode = head;
           int count =1;//whileҲ������forѭ����ʽ���
           while(count != index) {
               curNode =curNode.getNext();
               count++;
           }
           curNode.setData(data);
       }
   }

   //��ȡ����ĳ���
   public int  listLength() {
       return length;
   }

   //�����������
   public void printOrderNode() {
       if(head == null) {
           System.out.println("�ձ�");
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