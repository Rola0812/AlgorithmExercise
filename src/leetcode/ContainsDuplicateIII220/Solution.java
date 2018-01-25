package leetcode.ContainsDuplicateIII220;

/*
* Given an array of integers,
* find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j]
* is at most t and the absolute difference between i and j is at most k.
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(k<1 || t<0){
            return false;
        }

        Map<Long,Long> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            //将数值与最小int数相减得到相对值，就省去了遍历数组得到数的范围
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;

            //计算对应的桶的编号
            long bucket = remappedNum/((long)t+1);

            if(map.containsKey(bucket) ||
                    (map.containsKey(bucket-1)&&remappedNum -map.get(bucket-1)<=t)||
                    (map.containsKey(bucket+1)&&map.get(bucket+1)-remappedNum<=t)){
                return true;
            }

            //当map的元素大于k个，即桶的个数大于k的时候，即
            if(map.entrySet().size() >= k){
                long lastBucket = ((long)nums[i-k] -Integer.MIN_VALUE)/((long)t+1);
                map.remove(lastBucket);
            }

            map.put(bucket,remappedNum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1};
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums,1,1));
    }
}
