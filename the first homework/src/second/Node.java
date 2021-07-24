package second;

public class Node {
  private int data;//数据域
  private Node next;//后继指针域
  private Node previous;//前驱指针域

  public Node(int data) {
      this.data = data;
      this.next = null;
      this.previous = null;
  }

  public int getData() {
      return data;
  }

  public void setData(int data) {
      this.data = data;
  }

  public Node getNext() {
      return next;
  }

  public void setNext(Node next) {
      this.next = next;
  }

  public Node getPrevious() {
      return previous;
  }

  public void setPrevious(Node previous) {
      this.previous = previous;
  }
  public void display() {
      System.out.print( data + " ");
  }
}