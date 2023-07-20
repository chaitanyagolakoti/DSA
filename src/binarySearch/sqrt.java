package binarySearch;

import java.util.Scanner;

public class sqrt {
	public static int binary(int low, int high, int k) {
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        int sq= mid*mid;
	        if (sq == k) {
	            return mid; 
	        } else if (sq < k) {
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    
	    return high; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		System.out.println(binary(1,k,k));
	}

}
