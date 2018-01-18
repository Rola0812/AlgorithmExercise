package Wangyi;

import java.util.Scanner;

public class Xiangfanshu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp = number;
        int reverse = 0;
        while(number>0){
            reverse = reverse*10 + number % 10;
            number /= 10;
        }
        System.out.print(temp+reverse);
    }
}
