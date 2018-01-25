package leetcode.ContainsDuplicateII219;

public class Solution {

    public boolean containsNearbyFuplicate(int[] nums,int k){

        for(int i = 0;i<nums.length;i++){
            int j = 1;
            while(i+j<nums.length && j<=k){
                if(nums[i+j] == nums[i]){
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1};
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyFuplicate(nums,1));
    }
}
