package DynamicProgramming.NumberToLetter;

import java.util.HashMap;

public class NumberToLetter {

    static HashMap<String,String> map;

    public static void main(String[] args) {
        String str = "10";
        map = new HashMap<String, String>();

        for(int i = 0;i<26;i++){
            map.put(String.valueOf(i+1),String.valueOf((char)(i+'a')));
            //System.out.println(map.get(String.valueOf(i+1)));
        }


        int[] p = getExchange(str);
        for(int i = 0;i<p.length;i++) {
            if(p[i] == -1){
                System.out.println(0);
                break;
            }
            System.out.println(p[i]+"\t");
        }
    }

    private static int[] getExchange(String str) {

        if(str == null || str.length() == 0){
            return null;
        }
        int[] p = new int[str.length()];
        int init = 0;


        p[0] = map.get(str.charAt(0)+"")==null?-1:1;


        if(str.charAt(1) == '0'){
            p[1] = map.get(str.substring(0,1)+"") == null?-1:1;
        }else {
            p[1] = map.get(str.substring(0,1)+"") == null?p[0]:p[0]+1;
        }


        for(int i = 2;i<str.length();i++){
            if(str.charAt(i) == '0'){
                p[i] = map.get(str.substring(i-1,i)+"") == null?-1:p[i-2];

            }else{
                p[i] = map.get(str.substring(i-1,i)+"") == null?p[i-1]:p[i-1]+p[i-2];
            }
        }

        return p;
    }


}
