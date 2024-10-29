/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dslkdonDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author TGDD
 */
public class dslkdon_main {

    /**
     * @param args the command line arguments
     */
    static LinkList list = new LinkList();

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean bool = true;

        do {
            menu();
            int chon = sc.nextInt();
            switch (chon) {
                case 0 -> {
                    System.out.println("Da thoat chuong trinh");
                    bool = false;
                }
                case 1 -> {
                    System.out.println("Nhap thong tin sinh vien");
                    System.out.print("Nhap so sinh vien: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhap ma sinh vien: ");
                        String maSV = sc.nextLine();
                        System.out.print("Nhap ten sinh vien: ");
                        String hoten = sc.nextLine();
                        System.out.print("Nhap diem sinh vien: ");
                        double diem = sc.nextDouble();
                        sc.nextLine();
                        list.insert(maSV, hoten, diem);
                    }
                }
                case 2 -> {
                    list.ghifile();
                    System.out.println("Ghi file thanh cong");
                }
                case 3 -> {
                    list.docfile();
                    System.out.println("Doc file thanh cong");
                }
                case 4 -> {
                    System.out.println("Danh sach sinh vien");
                    list.printList();
                }
                case 5 -> {
                    System.out.println("Ket qua sinh vien");
                    list.ketQua();
                }
                case 6 -> {
                    System.out.println("Xep loai sinh vien");
                    list.xepLoai();
                }
                case 7 -> {
                    System.out.println("Nhung sinh vien co diem cao nhat");
                    list.max();
                }
                case 8 -> {
                    System.out.println("Thong ke sinh vien theo xep loai");
                    list.thongKeXepLoai();
                }
                case 9 -> {
                    System.out.println("Sap xep sinh vien");
                    list.sapXep();
                }
                default ->
                    throw new AssertionError();
            }
        } while (bool == true);
    }

    public static void menu() {
        System.out.println("= = = = MENU = = = =");
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Ghi file");
        System.out.println("3. Doc file");
        System.out.println("4. Hien thi danh sach");
        System.out.println("5. Ket qua");
        System.out.println("6. Xep loai");
        System.out.println("7. Lon nhat");
        System.out.println("8. Thong ke");
        System.out.println("9. Sap xep");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Hay chon chuc nang: ");
    }

}
