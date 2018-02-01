package ZuoshenAlgorithm.Section5.FanzhuanString11;

public class SolutionBuchong1 {

    public void rotate(char[] chas,int size){
        if(chas == null || chas.length ==0 ||size<=0 || size>=chas.length){
            return;
        }
        reverse(chas,0,size-1);
        reverse(chas,size,chas.length-1);
        reverse(chas,0,chas.length-1);

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
}
