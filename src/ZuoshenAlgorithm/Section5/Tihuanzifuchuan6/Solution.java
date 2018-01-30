package ZuoshenAlgorithm.Section5.Tihuanzifuchuan6;

public class Solution {

    public String replace(String str, String from, String to){
        if(str == null || from == null || str.length() == 0 || from.length() == 0){
            return str;
        }
        char[] strchars = str.toCharArray();
        char[] fromchars = from.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        int match = 0;

        for(int i = 0;i<strchars.length;i++){
            if(strchars[i] == fromchars[match++]){
                if(match == fromchars.length){
                    sb.append(to);
                    temp.delete(0,temp.length());
                    match = 0;
                }else{
                    temp.append(strchars[i]);
                }
            }else{
                sb.append(temp);
                temp.delete(0,temp.length());
                sb.append(strchars[i]);
                match = 0;
            }
        }
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replace("123abc","abc","4567"));
    }
}
