package binarySearch;
import java.util.Scanner;

public class MountainArray {
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int peakIndex = findPeakElement(arr, 0, n - 1);
        int peakValue = arr[peakIndex];
        
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + peakValue);
    }
}
