package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort1 {
    static void mergeSort(int arr[], int n) {
        if (n <= 1) {
            return;
        }
        int mid = n / 2;
        int left[] = Arrays.copyOfRange(arr, 0, mid);
        int right[] = Arrays.copyOfRange(arr, mid, n);
        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(arr, left, right, mid, n - mid);
    }

    private static void merge(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}

