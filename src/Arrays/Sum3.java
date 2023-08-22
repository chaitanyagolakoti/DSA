package Arrays;

import java.util.*;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // Store indexes and elements in a HashMap
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element
                int third = -(nums[i] + nums[j]);

                // Check if the third element exists in the HashMap and is not a duplicate
                if (indexMap.containsKey(third) && indexMap.get(third) != i && indexMap.get(third) != j) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    result.add(temp);
                }
                indexMap.put(nums[i], i);
            }
        }

        // Remove duplicates from the result using a set
        Set<List<Integer>> resultSet = new HashSet<>(result);

        return new ArrayList<>(resultSet);
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
