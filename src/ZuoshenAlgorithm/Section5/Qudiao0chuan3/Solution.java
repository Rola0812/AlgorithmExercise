package ZuoshenAlgorithm.Section5.Qudiao0chuan3;

public class Solution {

    public String removeKZeros(String str,int k){
        int count = 0;
        int start = -1;
        StringBuilder sb=new StringBuilder();
        char[] chs = str.toCharArray();

        for(int i = 0;i<chs.length;i++){
            char ch = chs[i];
            if(ch =='0'){
                count++;
                start = start == -1?i:start;
            }else{
                if(count != k){
                    while(count != 0){
                        sb.append('0');
                        count--;
                    }
                }
                sb.append(ch);
                count = 0;
                start = -1;
            }
        }
        if(count!=k)
        {
            while(count !=0)
            {
                sb.append('0');
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKZeros("A0000B000D",3));
    }
}
