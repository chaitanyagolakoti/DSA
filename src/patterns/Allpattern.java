package patterns;
import java.util.Scanner;
public class Allpattern {
    static void pattern1(int n ) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n ) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n ) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n ) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <=row; col++) {
                System.out.print(col+1+" ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n ) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            if(n-row == n) {
                continue;
            }
            for (int col = 0; col <n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern6(int n ) {
        for (int row = 0; row < n; row++) {
            for(int col=0;col<n-row-1;col++) {
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern7(int n ) {
        for (int row = 0; row < n; row++) {
            for (int space=n-row; space>1; space--){
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //diamond
    static void pattern8(int n ) {
        for (int row = 0; row < n; row++) {
            for (int space=n-row; space>1; space--){
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col = col+1) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            if(n-row==n) {
                continue;
            }
            for (int space=0; space<row; space++){
                System.out.print(" ");
            }
            for (int col = 0; col <n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern9(int n) {

        for(int row=1;row<=n;row++) {
            for (int space=0; space<n-row; space++){
                System.out.print("  ");
            }
            for(int col=row;col>=1;col--) {
                System.out.print(col+" ");
            }
//			System.out.println();
            for(int col=2;col<=row;col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern10(int n) {
        for (int row = 1; row <=n; row++) {
            for (int col = row; col <= n; col++) {
                System.out.print("*");
            }
            for (int space=1; space<=2*row-2; space++){
                System.out.print(" ");
            }
            for (int col = row; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n-1; row>=1; row--) {
            for (int col = row; col <= n; col++) {
                System.out.print("*");
            }
            for (int space=1; space<=2*row-2; space++){
                System.out.print(" ");
            }
            for (int col = row; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern11(int n) {
        for(int row=0;row<n;row++) {
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * (n - row-1); space++) {
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n-2; row>=0; row--) {
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * (n - row-1); space++) {
                System.out.print(" ");
            }
            for (int col = 0; col <=row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern12(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <=row; col++) {
                System.out.print(col+1);
            }
            for(int space=0;space<2*(n-row-1);space++) {
                System.out.print(" ");
            }
            for (int col = row; col>=0; col--) {
                System.out.print(col+1);
            }
            System.out.println();
        }
    }
    static void pattern13(int n) {
        for (int row = 1; row <=n; row=row+2) {
            for (int col = row-1; col < n; col = col+2) {
                System.out.print("*");
            }
            for (int space=1; space<row-1; space++){
                System.out.print(" ");
            }
            for (int col = row-1; col < n; col = col+2) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n; row>=1; row = row-2) {
            if(row == n)continue;
            for (int col = row-1; col < n; col = col+2) {
                System.out.print("*");
            }
            for (int space=1; space<row-1; space++){
                System.out.print(" ");
            }
            for (int col = row-1; col < n; col = col+2) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        pattern13(n);
    }

}

