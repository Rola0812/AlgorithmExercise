package DynamicProgramming.NumberToLetter;

public class ViolentSearch {

    public int num1(String str){
        if(str == null || str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        return process(chs,0);
    }

    private int process(char[] chs, int i) {

        if(i == chs.length){
            return 1;
        }
        if(chs[i] == '0'){
            return 0;
        }
        int res = process(chs,i+1);

        if(i+1<chs.length&&(chs[i]-0)*10+chs[i+1]-'0'<27){
            res +=process(chs,i+2);
        }
        return res;
    }

}
