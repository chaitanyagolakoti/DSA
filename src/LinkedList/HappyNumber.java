package LinkedList;

/*
    Why this question has given in linked list folder coz we can complete the problem using Fast and SLow pointer approach
    which is widely used for linked lists, if not that ans alternate HashSet approach is provided as well.

    **The reason the do-while loop works correctly and plane while loop doesn't is that it ensures the
    do-while loop runs at least once before checking the condition for termination.**
    Happy Coding.....
*/

import java.util.HashSet;
public class HappyNumber {
    static boolean happy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    static int getNextNumber(int n) {
        int sqSum = 0;
        while (n > 0) {
            int digit = n % 10;
            sqSum += digit * digit;
            n /= 10;
        }
        return sqSum;
    }
    public static boolean HappyNum(int n){
        int fast = n;
        int slow = n;
        do {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }while(slow != fast);
        return slow==1;
    }
    public static void main(String[] args) {
        System.out.println(HappyNum(1111111));
    }
}
