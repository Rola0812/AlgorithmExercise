package ZuoshenAlgorithm.Section1.SortStack5;

import java.util.Stack;

public class Solution {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        if(stack.isEmpty()){
            throw new RuntimeException("err");
        }else {
            while(!stack.isEmpty()){
                int cur = stack.pop();
                if(help.isEmpty() || help.peek()>=cur){
                    help.push(cur);
                }else {
                    while(cur>help.peek()){
                        stack.push(help.pop());
                    }
                    help.push(cur);
                }
            }

        }

        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
