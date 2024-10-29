/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dequy;

/**
 *
 * @author TGDD
 */
public class cacbaitoandequy {

    public static void chuyenNP(int n) {
        if (n != 0) {
            chuyenNP(n / 2);
            System.out.print(n % 2);
        }
    }

    public static int f(int n) {
        if ((n == 1) || (n == 2)) return 1;
        else return f(n - 1) + f(n - 2);
    }

    public static int gthua(int n) {
        if (n == 0) return 1;
        else return n * gthua(n - 1);
    }

    public static int us(int a, int b) {
        if (a == b) return a;
        else if (a > b) return us(a - b, b);
        else return us(a, b - a);
    }

    public static int tong(int n) {
        if (n == 1) return 1;
        else return n + tong(n - 1);
    }

    public static int tongGthua(int n) {
        if (n == 1) return 1;
        else return gthua(n) + tongGthua(n - 1);
    }

    public static int luyThua(int x, int n) {
        if (n == 0) return 1;
        else return x * luyThua(x, n - 1);
    }

    public static int tongLthua(int n) {
        if (n == 1) return 1;
        else return luyThua(n, n) + tongLthua(n - 1);
    }

    public static void solveHanoi(int n, char source, char auxiliary, char target) {
        if (n == 1) {
            System.out.println("Di chuyển đĩa " + n + " từ " + source + " sang " + target);
            return;
        }

        solveHanoi(n - 1, source, target, auxiliary);

        System.out.println("Di chuyển đĩa " + n + " từ " + source + " sang " + target);

        solveHanoi(n - 1, auxiliary, source, target);
    }

}
