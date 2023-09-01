package Arrays;

public class CountSubarraysWithXOR {

    public static int XorRec(int arr[], int b, int start, int end) {
        if (start > end) {
            return 0;
        }

        int xor = 0;
        int count = 0;

        for (int i = start; i <= end; i++) {
            xor ^= arr[i];
            if (xor == b) {
                count++;
            }
        }

        return count + XorRec(arr, b, start + 1, end);
    }

    //optimal way


    public static int solve(int[] A, int B) {
        return XorRec(A, B, 0, A.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4};
        int b = 6;

        System.out.println(solve(arr, b));
    }
}
