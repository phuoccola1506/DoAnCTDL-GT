/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SapXep;

/**
 *
 * @author TGDD
 */
public class SelectionSort {
    // Hàm sắp xếp Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Duyệt qua từng phần tử trong mảng
        for (int i = 0; i < n - 1; i++) {
            // Giả sử phần tử đầu tiên của đoạn chưa sắp xếp là nhỏ nhất
            int minIndex = i;
            
            // Tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Cập nhật chỉ số của phần tử nhỏ nhất
                }
            }
            
            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của đoạn chưa sắp xếp
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
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
