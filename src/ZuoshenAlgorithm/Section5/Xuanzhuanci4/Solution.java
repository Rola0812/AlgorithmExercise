package ZuoshenAlgorithm.Section5.Xuanzhuanci4;

public class Solution {

    public boolean isRotation(String a, String b){
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        String s = b+b;
        if(s.contains(a)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isRotation("2ab1","ab12"));
    }
}
