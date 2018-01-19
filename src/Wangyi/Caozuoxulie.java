package Wangyi;

import java.util.Scanner;

public class Caozuoxulie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = Integer.valueOf(sc.nextLine()) ;
        int[] input = new int[nums];
        int[] out = new int[nums];
        for(int i = 0;i<nums;i++){
            input[i] = sc.nextInt();
        }
        for(int i = 0;i<nums;i++){
            parseIntArray2(input,i,out);
        }
        for(int i = 0;i<nums-1;i++){
            System.out.print(out[i]+" ");
        }
        System.out.print(out[nums-1]);
    }

    private static int[] parseIntArray2(int[] input,int i,int[] out) {
        out[i] = input[i];
        int[] temp = out.clone();
        int k = 0;
        for(int j = i;j>=0;j--){
            out[k] = temp[j];
            out[k] = out[k];
            k++;
        }
        return out;
    }

}
