/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dslkdoiDao;

import java.util.Scanner;

/**
 *
 * @author TGDD
 */
public class dslkdoi_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();
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
                    list.createList();
                }
                case 2 -> {
                    System.out.println("Xem thong tin sinh vien");
                    list.printListFull();
                }
                case 3 -> {
                    System.out.println("Tim kiem thong tin sinh vien");
                    String timKiem = sc.nextLine();
                    list.timKiemThongTin(timKiem);
                }
                case 4 -> {
                    System.out.println("Xoa sinh vien theo maSV");
                    String timKiem = sc.nextLine();
                    list.deleteWithSearch(timKiem);
                }
                case 5 -> {
                    System.out.println("Them mot sinh vien");
                    System.out.print("MaSV: ");
                    String newMaSV = sc.nextLine();
                    System.out.print("HoTen: ");
                    String newHoTen = sc.nextLine();
                    System.out.print("Diem: ");
                    double newDiem = sc.nextDouble();
                    sc.nextLine();
                    list.themSinhVien(newMaSV, newHoTen, newDiem);
                    list.printListFull();
                }
                case 6 -> {
                    System.out.println("Thong ke sinh vien theo xep loai");
                    list.thongKeSinhVien();
                }
                default -> throw new AssertionError();
            }
        } while (bool == true);
        
        list.createList();
        list.printListFull();
        list.search(sc.nextLine());
        
    }
    
    public static void menu() {
        System.out.println("= = = = MENU = = = =");
        System.out.println("1. Nhap du lieu sinh vien");
        System.out.println("2. Xem thong tin sinh vien");
        System.out.println("3. Tim kiem sinh vien");
        System.out.println("4. Xoa mot sinh vien");
        System.out.println("5. Them mot sinh vien");
        System.out.println("6. Thong ke sinh vien theo xep loai");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Hay chon chuc nang: ");
    }
    
}
