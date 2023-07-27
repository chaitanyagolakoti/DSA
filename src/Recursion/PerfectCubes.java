package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PerfectCubes {
    private static void findCombinations(int ind, int[] arr, int target, int count, int[] minCount) {
        if (target == 0) {
            minCount[0] = Math.min(minCount[0], count);
            return;
        }
        if (ind == arr.length || count >= minCount[0]) {
            return;
        }
        for (int i = 0; i <= target / arr[ind]; i++) {
            findCombinations(ind + 1, arr, target - (i * arr[ind]), count + i, minCount);
        }
    }
    public static int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        List<Integer> cubes = new ArrayList<>();
        for (int i = 1; ((i * i)*i)<= n; i++) {
            cubes.add(((i * i)*i));
        }
        int[] result = new int[cubes.size()];
        for (int i = 0; i < cubes.size(); i++) {
            result[i] = cubes.get(i);
        }
        int[] minCount = {2};
        findCombinations(0, result, n, 0, minCount);
        return minCount[0];
    }
    public static void main(String[] args) {
        int arr[] = {35,9,1};
        for (int i = 0; i < arr.length; i++) {
            int k = numSquares(arr[i]);
            if(arr[i] == 1){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
