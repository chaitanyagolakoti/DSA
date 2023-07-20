package binarySearch;

import java.util.Scanner;

public class ElementInMountainArray {
	public static int search(int arr[] , int k) {
		int peak = findPeakElement(arr,0,arr.length-1);
		int left = binary(arr,0,peak,k);
		int right = binary(arr,peak,arr.length-1,k);
		if(left<0){
            return right;
        }
        else if(right<0){
            return left;
        }
		return Math.min(left,right);
		
	}
	public static int findPeakElement(int arr[], int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // We are in the descending part of the array.
                // The peak element is on the right side.
                low = mid + 1;
            } else {
                // We are in the ascending or plateau part of the array.
                // The peak element is on the left side.
                high = mid;
            }
        }
        // At the end of the loop, 'low' and 'high' will be equal,
        // representing the index of the peak element.
        return low;
    }
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

	    return -1; // Ceiling value not found
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
		System.out.println(search(arr,k));
	}

}
