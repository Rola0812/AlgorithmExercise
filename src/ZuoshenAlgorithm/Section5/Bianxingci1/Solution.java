package ZuoshenAlgorithm.Section5.Bianxingci1;

public class Solution {

    public boolean isDeformation(String str1,String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        int[] map = new int[256];
        char[] str1chars = str1.toCharArray();
        char[] str2chars = str2.toCharArray();

        for(int i = 0;i<str1.length();i++){
            int ch = str1chars[i]-'0';
            map[ch]++;
        }
        for(int j = 0;j<str2.length();j++){
            int ch = str2chars[j]-'0';
            map[ch]--;
        }
        for(int k = 0;k<map.length;k++){
            if(map[k]!=0){
                return false;
            }
        }
        return true;
    }

}
