package ZuoshenAlgorithm.Section5.FanzhuanString11;

public class Solution {

    public void rotateWord(char[] chas){
        if(chas == null || chas.length == 0){
            return;
        }

        reverse(chas,0,chas.length-1);

        int wordLength = 0;
        for(int i = 0;i<chas.length;i++){
            if(chas[i]!=' '){
                wordLength++;
            }
            if(chas[i]==' '){
                reverse(chas,i-wordLength,i-1);
                wordLength = 0;
            }
        }
        reverse(chas,chas.length-wordLength,chas.length-1);
        for(char c:chas){
            System.out.print(c);
        }
    }

    private void reverse(char[] chas, int start, int end) {

        char tmp = 0;
        while(start < end){
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars = new char[]{'I','\'','m',' ','a',' ','s','t','u'};
        solution.rotateWord(chars);
    }

}
