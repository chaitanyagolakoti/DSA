package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckIfSubset {
    public static String isSubset( long arr1[], long arr2[]) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                map.put(arr2[i], map.get(arr2[i]) - 1);
            } else {
                return "No";
            }
        }
        return "Yes";
    }
    public static void main(String[] args) {
        long arr1[] = { 9, 9, 9, 9, 6, 7, 4 };
        long arr2[] = {9,9,6,7,9,8,9,9};
        System.out.println(isSubset(arr1,arr2));
    }
}
