package ZuoshenAlgorithm.Section5.ValidString14;

public class Solution {

    public boolean isValid(String str){
        char[] chars = str.toCharArray();
        int left = 0;
        int right = 0;
        for(int i = 0;i<chars.length;i++){
            if(chars[i]!='(' && chars[i]!=')'){
                return false;
            }
            if (chars[i]=='('){
                left++;
            }
            if(chars[i]==')'){
                right++;
            }
            if(right>left){
                return false;
            }
            if(i == chars.length-1 && chars[i]=='('){
                return false;
            }
        }
        if(right != left){
            return false;
        }
        return true;
    }
}
