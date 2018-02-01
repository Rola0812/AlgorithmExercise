package ZuoshenAlgorithm.Section5.Zuixiaojuli12;

public class Solution {

    public int minDistance(String[] strs,String str1,String str2){
        if(strs == null || strs.length == 0 || str1 == null || str2 == null){
            return -1;
        }
        if(str1.equals(str2)){
            return 0;
        }
        int index1 = Integer.MIN_VALUE;
        int index2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<strs.length;i++){
            if(strs[i].equals(str1)){
                index1 = i;
            }
            if(strs[i].equals(str2)){
                index2 = i;
            }
            if(Math.abs(index1-index2)<min){
                min = Math.abs(index1-index2);
            }
        }
        System.out.println(min == Integer.MAX_VALUE?-1:min);
        return min == Integer.MAX_VALUE?-1:min;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"1","3","3","3","2","3","1"};
        String s1 = "1";
        String s2 = "2";
        Solution solution = new Solution();
        solution.minDistance(strs,s1,s2);
    }

}
