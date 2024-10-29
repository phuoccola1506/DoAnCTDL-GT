/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dequy;

/**
 *
 * @author TGDD
 */
public class cacbaitoankhudequy {

    public static int giaiThua(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Dau vao khong duoc am");
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // cau 2
    public static double luyThua(double x, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("So mu khong duoc am");
        }

        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    // cau 3
    public static String nhiPhan(int n) {
        String nhiphan = "";

        while (n > 0) {
            nhiphan = (n % 2) + nhiphan;
            n = n / 2;
        }

        if (nhiphan.equals("")) {
            nhiphan = "0";
        }

        return nhiphan;
    }

    // cau 4
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int fib = 1;

        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }
}
