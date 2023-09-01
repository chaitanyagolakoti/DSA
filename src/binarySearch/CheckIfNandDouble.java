package binarySearch;

import java.util.Arrays;

public class CheckIfNandDouble {
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 2*arr[i];
            int left = 0;
            int right = arr.length-1;
            while (left<right){
                int mid = left + (right-left)/2;
                if(arr[mid]==target){
                    return true;
                }
                if(arr[mid]>target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
