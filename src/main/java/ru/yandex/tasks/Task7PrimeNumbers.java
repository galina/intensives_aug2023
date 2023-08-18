// Extra task https://leetcode.com/problems/prime-in-diagonal/

package ru.yandex.tasks;

import java.util.Arrays;
import java.util.ArrayList;

public class Task7PrimeNumbers {
    public static int[] findPrimes (int N) {
        /*
         * 2 <= N <= 10^6
         * Выход: отсортированный массив всех простых чисел от 2 до N
         */
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        int[] result = new int[primes.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = primes.get(i);
        }
        return result;
    }

    public static boolean isPrime(int i) {
        for (int j = 2; j < Math.sqrt(i); ++j) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }
}
