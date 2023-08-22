package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ProductExceptItself {
    static List<Integer> product(int arr[]){
        List<Integer> ans = new ArrayList<>();
        int pro=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length; j++){
                if(j!=i) pro *= arr[j];
                else {
                    continue;
                }
            }
            ans.add(pro);
            pro=1;
        }
        return ans;
    }

    //optimised way

    static int left(int arr[], int ind){
        if(ind ==0){
            return 1;
        }
        int ans = 1;
        for(int i=ind-1;i>=0;i--){
            ans *= arr[i];
        }
        return ans;
    }
    static int right(int arr[], int ind){
        if(ind == arr.length-1){
            return 1;
        }
        int ans = 1;
        for(int i=ind+1;i<arr.length;i++){
            ans *= arr[i];
        }
        return ans;
    }
    static List<Integer> product1(int arr[]){
        List<Integer> ansL = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int ans = 1;
            ans = left(arr,i)*right(arr,i);
            ansL.add(ans);
        }
        return ansL;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        System.out.println(product1(arr));
    }
}
