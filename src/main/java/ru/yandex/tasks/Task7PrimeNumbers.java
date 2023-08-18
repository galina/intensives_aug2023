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
        boolean[] primes = new boolean[N + 1];
        for (int i = 2; i <= N; ++i) {
            primes[i] = true;
        }
        int primesCount = N - 2;
        for (int i = 2; i <= N; ++i) {
            if (primes[i] && i <= Math.sqrt(N)) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                    primesCount -= 1;
                }
            }
        }
        int[] result = new int[primesCount];
        for (int i = 0, j = 0; i <= N; ++i) {
            if (primes[i]) {
                result[j] = i;
                j += 1;
            }
        }
        return result;
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }
}
