package binarySearch;

import java.util.Scanner;

public class SearchRotatedArray {
    public static int binary(int arr[], int low, int high, int k) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid; // Exact match found
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Value not found
    }

    public static int peak(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            } else if (arr[low] > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int rotated(int arr[], int k) {
        int p = peak(arr);
        if (p >= 0) {
            int left = binary(arr, 0, p, k);
            int right = binary(arr, p + 1, arr.length - 1, k);

            return Math.max(left, right);
        } else {
            return binary(arr, 0, arr.length - 1, k);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) { 
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(rotated(arr,k));
		
//		int arr[] = {4,5,6,7,0,1,2};
//		System.out.println(peak(arr));
	}

}
