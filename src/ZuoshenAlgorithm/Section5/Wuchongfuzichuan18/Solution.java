package ZuoshenAlgorithm.Section5.Wuchongfuzichuan18;

import java.util.HashMap;
import java.util.Map;

//https://www.cnblogs.com/haozhengfei/p/d0906ebc98f7b6eaecb3ecd738dc78ac.html

public class Solution {

    public int maxUnique(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();

        Map<Character,Integer> charPosition = new HashMap<Character, Integer>();

        //preArr代表以s[i-1]结尾的情况下，最长无重复子串的长度
        int[] preArr = new int[chars.length];

        for(int i = 0;i<str.length();i++){
            Integer lastPosOfChar = charPosition.get(chars[i]);

            if(lastPosOfChar == null){//说明当前字符第一次出现
                //更新最长无重复子串的长度
                preArr[i] = i ==0?1:preArr[i-1]+1;
                //记录当前字符出现的位置
                charPosition.put(chars[i], i);
            }else {//当前字符不是第一次出现(既然不是第一次出现，那也不是在第一个位置),也就是之前出现过该字符
                //获取前一个字符最长无重复子串的长度
                int aPos = lastPosOfChar + 1;
                int unRepeatLen = preArr[i-1];
                int bPos = i - unRepeatLen;
                if(aPos >=bPos){
                    //当前位置的最长无重复子串长度
                    preArr[i] = i - aPos + 1;
                }
                else {
                    //当前位置的最长无重复子串长度
                    preArr[i] = i - bPos + 1;
                }
                //跟新当前字符出现的位置
                charPosition.put(chars[i], i);
            }
        }
        int max = preArr[0];
        for(int i:preArr){
            if (i>max)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxUnique("aabcd"));
    }

}
