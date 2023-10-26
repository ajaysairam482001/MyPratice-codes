package Ajayjava;
import java.util.ArrayList;
import java.util.List;

import static Ajayjava.Find_premutations.findPermutations;
//importing from another file in the same package

public class Prime_Checker {
    /**
     * Have the function PrimeChecker(num) take num and return 1
     * if any arrangement of num comes out to be a prime number, otherwise return 0.
     * For example: if num is 910, the output should be 1
     * because 910 can be arranged into 109 or 019, both of which are primes
     */

        /**
         * Collection of permutations.
         * E.g. [5, 9, 1, 2, 1, 5] -> 591521, 591512, 591251, 591215, ...
         */

        private static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }

            if (num == 2) {
                return true;
            }

            if (num % 2 == 0) {
                return false;
            }
            double upper = Math.sqrt(num) + 1;
            for (int i = 3; i < upper; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }


        private static int primeChecker(int num) {
            List<Integer> permutations;
            permutations = Find_premutations.convert(findPermutations(String.valueOf(num),""));
            for (int i : permutations) {
                if (isPrime(i)) {
                    return 1;
                }
            }
            return 0;
        }

        public static void main(String[] args) {
//            int result1 = primeChecker(591521);
//            System.out.println(result1);
//            int result2 = primeChecker(910);
//            System.out.println(result2);
            int result3 = primeChecker(2468);
            System.out.println(result3);
        }

    }

