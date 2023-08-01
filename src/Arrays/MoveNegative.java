package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MoveNegative {
    static void move(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < 0 && arr[j] > 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                    break;
                }
            }
        }
    }

    //Optimised version

    static int[] MoveWithSpace(int arr[]){
        int n = arr.length;
        int temp[] = new int[n];
        int j=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>=0){
                temp[j] = arr[i];
                j++;
            }
        }
        if (j == n || j == 0) {
            return arr;
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]<0){
                temp[j] = arr[i];
                j++;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int arr[] = {1, -1, 3, 2, -7, -5, 11, 6 };
        System.out.println(Arrays.toString(MoveWithSpace(arr)));
    }
}
