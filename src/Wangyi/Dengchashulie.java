package Wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Dengchashulie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int[] arrays = new int[nums];
        for(int i = 0;i<nums;i++){
            arrays[i] = sc.nextInt();
        }
        Arrays.sort(arrays);
        int gap = arrays[1]-arrays[0];
        for(int i = 1;i<nums;i++){
            if(arrays[i]-arrays[i-1]!=gap){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");

    }
}
