package binarySearch;

import java.util.Scanner;

public class TwoSumII_InputArrayIsSorted {
	 public static int[] twoSum(int[] numbers, int target) {
	        int left = 0;
	        int right = numbers.length - 1;

	        while (left < right) {
	            int sum = numbers[left] + numbers[right];
	            
	            if (sum == target) {
	                return new int[]{left + 1, right + 1}; // Indices are 1-indexed
	            } else if (sum < target) {
	                left++; // Move the left pointer to increase the sum
	            } else {
	                right--; // Move the right pointer to decrease the sum
	            }
	        }

	        return new int[]{-1, -1}; // No solution found
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
		int num[] = twoSum(arr,k);
		for (int i = 0; i < num.length; i++) { 
			System.out.print(num[i]+" ");
		}
	}

}
