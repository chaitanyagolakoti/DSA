package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
    static int function(int arr[]){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 9, 6, 7, 4 };
        System.out.println(function(arr));
    }
}
