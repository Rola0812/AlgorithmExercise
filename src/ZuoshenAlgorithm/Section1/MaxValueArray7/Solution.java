package ZuoshenAlgorithm.Section1.MaxValueArray7;

import java.util.LinkedList;

public class Solution {

    public int[] getMaxWindow(int[] arr,int w){
        if(arr == null || w<1 ||arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == 1-w){
                qmax.peekFirst();
            }
            if(i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
