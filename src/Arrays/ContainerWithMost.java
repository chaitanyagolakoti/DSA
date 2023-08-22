package Arrays;

public class ContainerWithMost {
    static int area(int arr[]){
        int left = 0;
        int right = arr.length-1;
        int max = Integer.MIN_VALUE;
        while (left<right){
            int len = Math.min(arr[left], arr[right]);
            int area = len * (right-left);
            max = Math.max(area,max);
            if(arr[left]>arr[right]){
                right--;
            }
            else if(arr[left]<=arr[right]){
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1,8,6,8,5,3,4,1,2,5};
        System.out.println(area(arr));
    }
}
