package leetcode.ContainsDuplicateII219;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean containsNearbyFuplicate(int[] nums,int k){

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,11};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.containsNearbyFuplicate(nums,9));
    }
}
