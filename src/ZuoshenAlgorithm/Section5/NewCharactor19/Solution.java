package ZuoshenAlgorithm.Section5.NewCharactor19;

public class Solution {

    public String pointNewchar(String s,int k){
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=k;i++){
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                sb.append(chars[i]).append(chars[++i]);
            }
            if(chars[i] <= 'z' && chars[i] >= 'a'){
                sb.append(chars[i]);
            }
            if(i == k || i == k+1){
                return sb.toString();
            }
            sb.delete(0,sb.length());
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pointNewchar("aaABCDEcBCg",10));
    }
}
