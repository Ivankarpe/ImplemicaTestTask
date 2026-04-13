import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // read user input

        memo = new int[a + 1][a + 1]; // prepare array for memoization
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(bactrack(a, a)); // calculate and output results
    }

    public static int bactrack(int openingBrackets, int closinngBrackets) {

        if (openingBrackets == 0 && closinngBrackets == 0) { 
            // if none of the brakets availiable there only 1 way to make brackets sequence
            return 1;
        }

        if (memo[openingBrackets][closinngBrackets] != -1) {
            //if we alredy computed return old value
            return memo[openingBrackets][closinngBrackets];
        }

        int posibilities = 0;
        if (openingBrackets > 0) {
            //add posibilities if we add opening bracket
            posibilities += bactrack(openingBrackets - 1, closinngBrackets); 

        }
        if (closinngBrackets > openingBrackets) { // cant add closing brakets if there no unclosed brackets
            //add posibilities if we add closing bracket
            posibilities += bactrack(openingBrackets, closinngBrackets - 1);
        }

        memo[openingBrackets][closinngBrackets] = posibilities; // save result
        return posibilities;
    }
}
