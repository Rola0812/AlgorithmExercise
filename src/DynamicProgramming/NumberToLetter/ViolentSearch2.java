package DynamicProgramming.NumberToLetter;

public class ViolentSearch2 {

    public static int num2(String str){
        if(str==null || str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        //最后一位是0吗？若是则cur赋值为0，若不是则赋值为1；
        int cur = chs[chs.length-1] == '0'?0:1;
        int next = 1;
        int tmp = 0;

        for(int i = chs.length -2;i>=0;i--){
            if(chs[i] == '0'){
                next = cur;
                cur = 0;
            }else {
                tmp = cur;
                if((chs[i]-'0')*10+chs[i+1]-'0'<27){
                    cur +=next;
                }
                next = tmp;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        String str = "110";

        int p = num2(str);

        System.out.println(p);

    }
}
