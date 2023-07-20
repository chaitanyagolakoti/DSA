package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    static void Subset(int arr[], int index, List<List<Integer>> ans, List<Integer>ds){
        if(index==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[index]);
        Subset(arr,index+1,ans,ds);
        ds.remove(ds.size()-1);
        Subset(arr,index+1,ans,ds);
    }
    static List<List<Integer>> subsets(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        Subset(arr,0,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        System.out.println(subsets(arr));
    }
}
