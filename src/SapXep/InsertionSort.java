/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SapXep;

/**
 *
 * @author TGDD
 */
public class InsertionSort {
    // Hàm sắp xếp Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Duyệt qua từng phần tử từ vị trí thứ 2 đến cuối mảng
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lưu giá trị hiện tại
            int j = i - 1;

            // Di chuyển các phần tử của mảng đã sắp xếp (bên trái key)
            // và lớn hơn key sang phải
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Chèn key vào vị trí đúng
            arr[j + 1] = key;
        }
    }
    
    // Hàm hiển thị mảng
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
