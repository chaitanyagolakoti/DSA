package Arrays;
public class FindMissingElement {
    public static int getMissingNumber(int[] arr)
    {
        // Compute XOR of all the elements in the array
        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }
//        System.out.println(xor);
        // Compute XOR of all the elements from 1 to `n+1`
        for (int i = 1; i <= arr.length + 1; i++) {
            xor = xor ^ i;
        }
        return xor;
    }
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5 };
//        System.out.println(1^2);
        System.out.println("The missing number is " + getMissingNumber(arr));
    }
}
