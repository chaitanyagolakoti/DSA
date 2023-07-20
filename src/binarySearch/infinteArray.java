package binarySearch;

import java.util.Scanner;

public class infinteArray {
	public static int infinteBinary(int arr[], int target) {
		int start = 0;
		int end = 1;
		while(target > arr[end]) {
			int temp = end +1;
			end = end + (end - start +1)*2;
			start = temp;
		}
		return binary(arr,start,end,target);
	}
	public static int binary(int arr[], int start,int end, int k) {
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(k<arr[mid]) {
				end = mid-1;
			}
			else if(k>arr[mid]) {
				start = mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(infinteBinary(arr,k));
	}

}
