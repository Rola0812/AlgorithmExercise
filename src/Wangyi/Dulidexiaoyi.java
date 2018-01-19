package Wangyi;

import java.util.Scanner;

public class Dulidexiaoyi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();//每天的房屋租金
        int f = sc.nextInt();//已经有的水果数量
        int d = sc.nextInt();//现金
        int p = sc.nextInt();//每个水果的单价

        int days = 0;
        if(d>x*f){
            days = (d-x*f)/(x+p)+f;
        }else{
            days = d/x;
        }
        System.out.println(days);
    }
}
