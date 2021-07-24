package second;

public class List {
    public static void main(String[] args) {
        Linklist list = new Linklist();
        list.addHead(3);
        list.addHead(2);
        list.addHead(1);
        list.updateIndexData(3,0);
        list.printOrderNode();
    }
}