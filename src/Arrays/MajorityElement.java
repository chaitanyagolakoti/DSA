package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    static int majorityElement(int arr[], int n)
    {
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
            if(map.get(arr[i]) > n/2){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 9, 9, 9, 9, 6, 7, 4 };
        System.out.println(majorityElement(arr,arr.length));
    }
}
