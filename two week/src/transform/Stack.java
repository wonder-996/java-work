package transform;

public class Stack {
	private int maxSize;
    private int[] stack; 
    private int top = -1;
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];} 
    int peek(){
            return stack[top];  
        }
    boolean Empty() {
            return top == -1; 
        }
        boolean Full() {
            return top == maxSize - 1; 
        }
        void push(int val){
            if(Full()){
                System.out.println("Õ»Âú~~");
                return;
                }
            top++; 
            stack[top] = val;
}    
        int pop() {
            if(Empty()) {
                throw new RuntimeException("Õ»¿Õ~");
            }
            int value = stack[top];
            top--;
            return value;
        }
		private boolean search(int element){
            if(Empty()){
                System.out.println("Õ»¿ÕÎŞÔªËØ");
                return false;
            }
            for (int i = top; i >= 0;i--){
                if(element == stack[i]) return true;
            }
            return false;
        }
        }

