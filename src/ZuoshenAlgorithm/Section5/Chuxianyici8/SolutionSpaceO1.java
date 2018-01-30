package ZuoshenAlgorithm.Section5.Chuxianyici8;

public class SolutionSpaceO1 {

    public boolean isUnique2(char[] chas){
        if(chas == null){
            return true;
        }
        heapSort(chas);
        for(int i = 1;i<chas.length;i++){
            if(chas[i] ==  chas[i-1]){
                return false;
            }
        }
        return true;
    }

    private void heapSort(char[] chas) {

        for(int i = 0;i<chas.length;i++){
            heapInsert(chas,i);
        }
        for(int i = chas.length-1;i>0;i--){
            swap(chas,0,i);
            heapify(chas,0,i);
        }
    }

    private void heapify(char[] chas, int i, int size) {

        int left = i*2+1;
        int right = i*2+2;
        int largest = i;

        while(left<size){
            if(chas[left]>chas[i]){
                largest = left;
            }
            if(right<size && chas[right] >chas[largest]){
                largest = right;
            }
            if(largest != i){
                swap(chas,largest,i);
            }else {
                break;
            }
            i = largest;
            left = i*2 +i;
            right = i*2 +2;

        }


    }

    private void heapInsert(char[] chas, int i) {
        int parent = 0;
        while(i != 0){
            parent = (i-1)/2;
            if(chas[parent]<chas[i]){
                swap(chas,parent,i);
                i = parent;
            }else {
                break;
            }
        }
    }

    private void swap(char[] chas, int index1, int index2) {
        char tmp = chas[index1];
        chas[index1] = chas[index2];
        chas[index2] = tmp;
    }


}
