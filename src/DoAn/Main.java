/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DoAn;

import SapXep.InsertionSort;
import SapXep.QuickSort;
import SapXep.SelectionSort;
import dequy.cacbaitoandequy;
import dequy.cacbaitoankhudequy;
import dslkdonDao.LinkList;
import static dslkdonDao.dslkdon_main.menu;
import java.util.Scanner;

/**
 *
 * @author TGDD
 */
public class Main {

    static LinkList list = new LinkList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        boolean bool = true;

        do {
            menuChinh();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    menuDeQuy();
                    int chon = sc.nextInt();
                    sc.nextLine();
                    switch (chon) {
                        case 1 -> {
                            System.out.println("Giai bai toan Fibonacy");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Fibonacy cua " + n + " la: " + cacbaitoandequy.f(n));
                        }
                        case 2 -> {
                            System.out.println("Giai bai toan Giai thua");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Giai thua cua " + n + " la: " + cacbaitoandequy.gthua(n));
                        }
                        case 3 -> {
                            System.out.println("Giai bai toan Tong giai thua");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Tong giai thua cua " + n + " la: " + cacbaitoandequy.tongGthua(n));
                        }
                        case 4 -> {
                            System.out.println("Giai bai toan Luy thua");
                            System.out.print("Nhap so a: ");
                            int a = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Luy thua bac " + n + " cua " + a + " la: " + cacbaitoandequy.luyThua(a, n));
                        }
                        case 5 -> {
                            System.out.println("Giai bai toan Tong luy thua");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Tong luy thua cua " + n + " la: " + cacbaitoandequy.tongLthua(n));
                        }
                        case 6 -> {
                            System.out.println("Giai bai toan UCLN");
                            System.out.print("Nhap so a: ");
                            int a = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nhap so b: ");
                            int b = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan UCLN cua " + a + " va " + b + " la: " + cacbaitoandequy.us(a, b));
                        }
                        case 7 -> {
                            System.out.println("Giai bai toan Town of Hanoi");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan Town of Hanoi cua " + n + " la: ");
                            cacbaitoandequy.solveHanoi(n, 'a', 'b', 'c');
                        }
                        case 8 -> {
                            System.out.println("Giai bai toan khu nhi phan");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan khu nhi phan cua " + n + " la: " + cacbaitoankhudequy.nhiPhan(n));
                        }
                        case 9 -> {
                            System.out.println("Giai bai toan khu Fibonacy");
                            System.out.print("Nhap so n: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Ket qua bai toan khu nhi phan cua " + n + " la: " + cacbaitoankhudequy.fibonacci(n));
                        }
                        case 0 -> {
                            System.out.println("Da thoat chuong trinh!");
                            bool = false;
                        }
                        default ->
                            System.out.println("Lua chon khong phu hop, hay chon lai!");
                    }
                }
                case 2 -> {
                    menuSapXep();
                    int chon = sc.nextInt();
                    switch (chon) {
                        case 1 -> {
                            System.out.println("Sap xep kieu Selection Sort");
                            System.out.print("Nhap so phan tu cua mang: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            int[] arr = new int[n];

                            for (int i = 0; i < n; i++) {
                                System.out.print("Duyet phan tu thu: " + (i + 1));
                                arr[i] = sc.nextInt();
                                sc.nextLine();
                            }

                            System.out.println("Mang truoc khi sap xep:");
                            SelectionSort.printArray(arr);
                            SelectionSort.selectionSort(arr);
                            System.out.println("Mang sau khi sap xep:");
                            SelectionSort.printArray(arr);
                        }
                        case 2 -> {
                            System.out.println("Sap xep kieu Insertion Sort");
                            System.out.print("Nhap so phan tu cua mang: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            int[] arr = new int[n];

                            for (int i = 0; i < n; i++) {
                                System.out.print("Duyet phan tu thu: " + (i + 1));
                                arr[i] = sc.nextInt();
                                sc.nextLine();
                            }

                            System.out.println("Mang truoc khi sap xep:");
                            InsertionSort.printArray(arr);
                            InsertionSort.insertionSort(arr);
                            System.out.println("Mang sau khi sap xep:");
                            InsertionSort.printArray(arr);
                        }
                        case 3 -> {
                            System.out.println("Sap xep kieu Quick Sort");
                            System.out.print("Nhap so phan tu cua mang: ");
                            int n = sc.nextInt();
                            sc.nextLine();
                            int[] arr = new int[n];

                            for (int i = 0; i < n; i++) {
                                System.out.print("Duyet phan tu thu: " + (i + 1));
                                arr[i] = sc.nextInt();
                                sc.nextLine();
                            }

                            System.out.println("Mang truoc khi sap xep:");
                            QuickSort.printArray(arr);
                            QuickSort.quickSort(arr, 0, (arr.length - 1));
                            System.out.println("Mang sau khi sap xep:");
                            InsertionSort.printArray(arr);
                        }
                        case 0 -> {
                            System.out.println("Da thoat chuong trinh!");
                            bool = false;
                        }
                        default ->
                            System.out.println("Lua chon khong phu hop, hay chon lai!");
                    }
                }
                case 3 -> {
                    menuDslkDon();
                    int chon = sc.nextInt();
                    switch (chon) {
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
                        case 0 -> {
                            System.out.println("Da thoat chuong trinh");
                            bool = false;
                        }
                    }
                }
            case 0 -> {
                    System.out.println("Da thoat chuong trinh!");
                    bool = false;
                }
                default ->
                    System.out.println("Lua chon khong phu hop, hay chon lai!");
            }
        } while (bool == true);
        }

    public static void menuChinh() {
        System.out.println("========================================");
        System.out.println("|         CHUONG TRINH QUAN LY         |");
        System.out.println("========================================");
        System.out.println("| 1. De quy va khu de quy              |");
        System.out.println("| 2. Cac thuat toan sap xep            |");
        System.out.println("| 3. Danh sach lien ket don            |");
        System.out.println("| 4. Quan ly voi cau truc cay          |");
        System.out.println("| 0. Thoat chuong trinh                |");
        System.out.println("========================================");
        System.out.print("Hay chon chuc nang: ");
    }

    public static void menuDeQuy() {
        System.out.println("========================================");
        System.out.println("|         CHUONG TRINH DE QUY          |");
        System.out.println("========================================");
        System.out.println("| --- Bai toan de quy ---              |");
        System.out.println("| 1. Bai toan Fibonacy                 |");
        System.out.println("| 2. Bai toan giai thua                |");
        System.out.println("| 3. Bai toan tong giai thua           |");
        System.out.println("| 4. Bai toan luy thua                 |");
        System.out.println("| 5. Bai toan tong luy thua            |");
        System.out.println("| 6. Bai toan UCLN                     |");
        System.out.println("| 7. Bai toan Town of Hanoi            |");
        System.out.println("| --- Bai toan khu de quy ---          |");
        System.out.println("| 8. Bai toan khu nhi phan             |");
        System.out.println("| 9. Bai toan khu Fibonacy             |");
        System.out.println("| 0. Thoat chuong trinh                |");
        System.out.println("========================================");
        System.out.print("Hay chon chuc nang: ");
    }

    public static void menuSapXep() {
        System.out.println("========================================");
        System.out.println("|         CHUONG TRINH SAP XEP         |");
        System.out.println("========================================");
        System.out.println("| --- Bai toan de quy ---              |");
        System.out.println("| 1. Selection Sort                    |");
        System.out.println("| 2. Insertion Sort                    |");
        System.out.println("| 3. Quick Sort                        |");
        System.out.println("========================================");
        System.out.print("Hay chon chuc nang: ");
    }
    
    public static void menuDslkDon() {
        System.out.println("========================================");
        System.out.println("|         CHUONG TRINH DSLKDON         |");
        System.out.println("========================================");
        System.out.println("| 1. Nhap thong tin sinh vien          |");
        System.out.println("| 2. Ghi file                          |");
        System.out.println("| 3. Doc file                          |");
        System.out.println("| 4. Hien thi danh sach                |");
        System.out.println("| 5. Ket qua                           |");
        System.out.println("| 6. Xep loai                          |");
        System.out.println("| 7. Lon nhat                          |");
        System.out.println("| 8. Thong ke                          |");
        System.out.println("| 9. Sap xep                           |");
        System.out.println("| 0. Thoat chuong trinh                |");
        System.out.println("========================================");
        System.out.print("Hay chon chuc nang: ");
    }

}
