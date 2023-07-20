package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortInplace {
    static void mergeSort(int arr[], int start, int end) {
//		Arrays.sort(arr);
        if(end-start==1) {
            return;
        }
        int mid = (start + end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid, end);
        mergeInplace(arr,start, mid, end);
    }
    private static void mergeInplace(int arr[], int start, int mid, int end) {
        int mix[] = new int[end-start];
        int i=start;int j=mid;int k=0;
        while(i<mid && j<end) {
            if(arr[i]<arr[j]) {
                mix[k] = arr[i];
                i++;
            }
            else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j<end) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int k2 = 0; k2 < mix.length; k2++) {
            arr[start+k2] = mix[k2];
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr,0,n);
        System.out.println(Arrays.toString(arr));
    }

}
