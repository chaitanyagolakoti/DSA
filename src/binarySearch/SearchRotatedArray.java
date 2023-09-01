package binarySearch;

public class SearchRotatedArray {
    static int binary(int arr[], int k, int start, int end) {
        if(start>end) {
            return -1;
        }
        int mid = start + (end-start)/2;
        if(arr[mid]==k) {
            return mid;
        }
        if(arr[start]<=arr[mid]) {
            if(k>=arr[start] && k<=arr[mid]) {
                return binary(arr,k,start,mid-1);
            }
            else {
                return binary(arr,k,mid+1,end);
            }
        }
        if(k>=arr[mid] && k<=arr[end]) {
            return binary(arr,k,mid+1,end);
        }
        return binary(arr,k,start,mid-1);
    }
    static int rotated(int nums[], int target) {
        return binary(nums,target,0,nums.length-1);
    }
	public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8,0,1};
        System.out.println(rotated(arr, 0));
	}

}
