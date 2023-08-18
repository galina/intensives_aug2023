// Extra task https://leetcode.com/problems/minimum-index-of-a-valid-split/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой выбором!) numbers
         */
        for (int j = 0; j < numbers.size(); ++j) {
            int minelem = numbers.get(j);
            int m = j;
            for (int i = j + 1; i < numbers.size(); ++i) {
                int elem = numbers.get(i);
                if (minelem > elem) {
                    minelem = elem;
                    m = i;
                }
            }
            if (m == j) continue;
            int tmp = numbers.get(m);
            numbers.set(m, numbers.get(j));
            numbers.set(j, tmp);
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
