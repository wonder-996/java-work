package transform;

public class Transfrm {
	private int num;
    private int target;
    Stack stack = new Stack(100000000); 
    public Transfrm(int num, int target) {
        this.num = num;
        this.target = target;
    }
    public void changeNum(){
        if(num==0){  
            System.out.println("0");
        } else{
            while(num!=0){
            	 stack.push(num%target); 
                num/=target;
            }
        
    while (!stack.Empty()) {
    	if(stack.peek()==10) { 
    	 System.out.print("A");
            stack.pop(); 
        }else if(stack.peek()==11){
            System.out.print("B");
            stack.pop();
        }else if(stack.peek()==12){
            System.out.print("C");
            stack.pop();
        }else if(stack.peek()==13){
            System.out.print("D");
              stack.pop();
        }else if(stack.peek()==14){
            System.out.print("E");
            stack.pop();
        }else if (stack.peek()==15){
            System.out.print("F");
             stack.pop();
        }else{
            System.out.print(stack.pop());
        }
    }
}}}
    
