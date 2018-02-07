package ZuoshenAlgorithm.Section1.GetMinStack1;

import java.util.Stack;

public class Mystack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if(this.stackMin.empty()){
            stackMin.push(newNum);
        }else if(newNum <= this.getMin()){
                this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty.");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty.");
        }
        return this.stackMin.peek();
    }
}
