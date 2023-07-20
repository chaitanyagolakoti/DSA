package binarySearch;

import java.util.Scanner;

public class KthMissing {
    public static int findKthPositive(int[] arr, int k) {
        int[] mainArr = new int[1000];
        
        // Mark common elements as -1
        for (int num : arr) {
            if (num <= 1000) {
                mainArr[num - 1] = -1;
            }
        }
        
        // Perform linear search and count non-marked elements
        int count = 0;
        for (int i = 0; i < mainArr.length; i++) {
            if (mainArr[i] != -1) {
                count++;
            }
            if (count == k) {
                return i + 1;
            }
        }
        
        // Handle the case where k is greater than the number of missing elements
        return mainArr.length + (k - count);
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) { 
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(findKthPositive(arr,k));
	}
}