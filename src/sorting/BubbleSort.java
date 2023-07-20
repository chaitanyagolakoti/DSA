package sorting;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int arr[], int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static int getmaxIndex(int[] arr,int start,int last) {
        int max = start;
        for (int i = start; i <=last; i++) {
            if(arr[max]<arr[i]) {
                max = i;
            }
        }
        return max;
    }
    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length-i-1;
            int maxind = getmaxIndex(arr,0,last);
            swap(arr,maxind,last);
        }
        PrintArray(arr);
    }
    //____________________Bubble Sort____________________________//

    static void bubbleSort(int arr[]) {
        boolean swapped=false;
        int n = arr.length;
        for(int i=0;i<n;i++) {
            for(int j=1;j<n-i;j++) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
//		bubbleSort(arr);
        selectionSort(arr);
    }

}
