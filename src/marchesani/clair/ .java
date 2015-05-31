package marchesani.clair;

// Finds the largest number under 1,000,000 that can be written as the sum of consecutive prime numbers

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int sum = 2;
        external: for (int i = 3; sum < 1000000; i++) {
            int sqrt = (int)Math.ceil(Math.sqrt(i));
            for (int n : primes) {
                if (i % n == 0) continue external;
                if (n > sqrt) break;
            }
            sum += i;
            primes.add(i);
        }
        sum -= primes.get(primes.size() - 1);
        external2: for (int i = 0; i < primes.size(); i++) {
            int sqrt = (int)Math.ceil(Math.sqrt(sum));
            for (int j = 2; j < sum; j++) {
                if (sum % j == 0) break;
                if (j + 1 == sum) break external2;
            }
            sum -= primes.get(i);
        }
        System.out.println("The result is " + sum);
    }
}