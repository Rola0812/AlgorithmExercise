package ZuoshenAlgorithm.Section5.Zifuchuantiaozheng10;

public class Solution {

    public void replace(char[] chas){
        if(chas == null ||chas.length == 0){
            return;
        }
        int num = 0;
        int len = 0;
        for(len = 0;len<chas.length && chas[len]!=0;len++){
            if(chas[len]==' '){
                num++;
            }
        }
        int j = len+num*2;
        for(int i = len-1;i>=0;i--){
            if(chas[i] != ' '){
                chas[j--] = chas[i];
            }else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }
}
