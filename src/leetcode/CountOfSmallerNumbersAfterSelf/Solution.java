package leetcode.CountOfSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {

    class Node{
        int val, leftSum = 0, count = 0;
        Node left, right;
        public Node(int val){
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if(nums.length == 0){
            return Arrays.asList(count);
        }
        //将最后一个数设置为根节点
        Node root = new Node(nums[nums.length - 1]);
        for(int i = nums.length - 1; i >= 0; i--){
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }

    private int insert(Node node, int num){
        int sum = 0;
        while(node.val != num){
            if(node.val > num){
                if(node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            }else{
                sum += node.leftSum + node.count;
                if(node.right == null) node.right = new Node(num);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,2,6,1};
        ArrayList<Integer> arrayList = (ArrayList<Integer>) solution.countSmaller(nums);
        for(Iterator iterator = arrayList.iterator();iterator.hasNext();){
            System.out.print(iterator.next()+" ");
        }
    }
}
