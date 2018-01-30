package ZuoshenAlgorithm.Section5.Zichuanqiuhe2;

public class Solution {

    public int numSum(String str){

        if (str == null) {
            return 0;
        }

        int res = 0; //目前累加和
        int num = 0; //当前收集到的数字
        boolean posi = false; //正负

        char[] chs = str.toCharArray();
        for(int i = 0;i<chs.length;i++){
            if(chs[i]<='9'&&chs[i]>='0'){
                int cur = chs[i]-'0';
                num = num*10+(posi?cur:-cur);
            }else {
                res+=num;
                num = 0;
                if(chs[i] == '-'){
                    if(i-1>-1 && chs[i-1] =='-'){
                        posi = !posi;
                    }else {
                        posi = false;
                    }
                }else{
                    posi = true;
                }
            }
        }
        res+=num;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSum("A-1B--2C--D6"));
        solution.numSum("A-1B--2C--D6E");
    }
}
