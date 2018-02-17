package ZuoshenAlgorithm.Section3.SearchTree;

public class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }

    public boolean isPostArray(int[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }
        return  isPost(arr,0,arr.length-1);
    }

    private boolean isPost(int[] arr, int start, int end) {

        if(start == end){
            return true;
        }
        //less指向最后一个比最后一个数字小的数
        int less = -1;
        //more指向第一个比最后一个数字大的数
        int more = end;

        for(int i = start;i<end;i++){
            if(arr[end] > arr[i]){
                less = i;
            }else {
                more = more == end ? i:more;
            }
        }
        //意味着，前面的数比最后一位数都大，或者前面的数比最后一个数都小
        if(less == -1 || more == end){
            return isPost(arr,start,end-1);
        }
        if(less != more - 1){
            return false;
        }
        return isPost(arr,start,less) && isPost(arr,more,end-1);

    }

    public Node posArrayToBST(int[] posArr){

        if(posArr == null){
            return null;
        }
        return posToBST(posArr,0,posArr.length-1);

    }

    private Node posToBST(int[] posArr, int start, int end) {

        if(start > end){
            return null;
        }

        int less = -1;
        int more = end;
        Node node = new Node(posArr[end]);

        for(int i = start;i<end;i++){

            if(posArr[i]<posArr[end]){
                less = i;
            }else {
                more = more == end ? i:more;
            }
        }
        if(less == -1 || more == end){
            return posToBST(posArr,start,end-1);
        }
        if(less != more-1){
            return null;
        }
        node.left = posToBST(posArr,start,less);
        node.right = posToBST(posArr,more,end-1);
        return node;
    }

}
