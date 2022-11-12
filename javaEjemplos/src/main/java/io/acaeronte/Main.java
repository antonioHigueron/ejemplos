package main.java.io.acaeronte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (1 <= T && T-- <= 100) {
            int s = sc.nextInt();
            int b = sc.nextInt();
            int cap = sc.nextInt();
            int r = b / cap;
            int q = r + 1;
            if (b <= cap) {
                System.out.println(+s);
            }else if (b == 0 && s == 0 && cap == 0) {
                System.out.println(0);
            } else {
                System.out.println(q * s);
            }
        }
    }
}