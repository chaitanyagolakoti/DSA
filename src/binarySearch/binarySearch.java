package binarySearch;

import java.util.Scanner;

public class binarySearch {
	static int binary(int arr[],int low, int high, int k) {
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(arr[mid]==k) {
				return mid;
			}
			else if(k>arr[mid]) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
		return -1;
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
		System.out.println(binary(arr,0,n-1,k));
	}

}
