import java.math.BigInteger;

public class Task3 {
    public static void main(String[] args) throws Exception {
        BigInteger a = BigInteger.ONE;

        //calculate 100! 
        for (long i = 1; i <= 100; i++) {
            a = a.multiply(BigInteger.valueOf(i));
        }

        int sum = 0;

        //transform bigint to string and add each char to sum
        for (char c : a.toString().toCharArray()) {
            sum += c - '0';
        }


        System.out.println(sum); // output result
    }
}