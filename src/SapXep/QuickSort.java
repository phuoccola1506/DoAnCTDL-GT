/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SapXep;

/**
 *
 * @author TGDD
 */
public class QuickSort {
    // Hàm sắp xếp QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Phân chia mảng và lấy chỉ số của pivot
            int pivotIndex = partition(arr, low, high);
            // Sắp xếp các phần bên trái và bên phải của pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Hàm phân chia mảng
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Chọn pivot là phần tử cuối
        int i = low - 1; // Chỉ số của phần tử nhỏ hơn

        // Duyệt qua mảng từ low đến high - 1
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++; // Tăng chỉ số của phần tử nhỏ hơn
                // Hoán đổi arr[i] với arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Hoán đổi arr[i + 1] với arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Trả về chỉ số của pivot
    }

    // Hàm hiển thị mảng
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
