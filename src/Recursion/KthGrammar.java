package Recursion;

public class KthGrammar {
    public static int kthGrammar(int n, int k) {
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int) (Math.pow(2,n-2));
        if (k<=mid){
            return kthGrammar(n-1,k);
        }
        return  1^kthGrammar(n-1,k-mid);
    }
    int kthGrammarNaiveMemoryEfficient(int n, int k){
        String previousRow = "0";
        for (int i = 1; i < n; i++){
            StringBuilder currentRow = new StringBuilder();
            for (char c : previousRow.toCharArray()){
                if (c == '0'){
                    currentRow.append("01");
                } else {
                    currentRow.append("10");
                }
            }
            previousRow = currentRow.toString();
        }
        return Character.getNumericValue(previousRow.charAt(k-1));
    }
    public static void main(String[] args) {
        System.out.println(kthGrammar(4, 3));
    }
}
