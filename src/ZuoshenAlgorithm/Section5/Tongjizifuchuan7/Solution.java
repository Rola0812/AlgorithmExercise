package ZuoshenAlgorithm.Section5.Tongjizifuchuan7;

public class Solution {

    public String getCountString(String str){
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        int count = 1;
        for(int i = 1;i<chs.length;i++){
            if(chs[i]==chs[i-1]){
                count++;
            }else {
                sb.append(chs[i-1]).append('_').append(count).append("_");
                count=1;
            }
            if(i == chs.length-1){
                sb.append(chs[i]).append('_').append(count);
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCountString("aaabbadddffc"));
    }

}
