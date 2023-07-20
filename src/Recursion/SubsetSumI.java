package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {
    static void Subset(int arr[], int index,int sum,List<Integer>ds){
        if(index==arr.length){
            ds.add(sum);
            return;
        }
        Subset(arr,index+1,sum+arr[index],ds);
        Subset(arr,index+1,sum,ds);
//        ds.remove(ds.size() - 1);
    }
    static List<Integer> subsets(int arr[]){
        List<Integer> ans = new ArrayList<>();
        Subset(arr,0,0,ans);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(subsets(arr));
    }
}
