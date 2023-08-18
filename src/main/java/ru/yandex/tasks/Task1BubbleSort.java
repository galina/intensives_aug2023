// Extra task https://leetcode.com/problems/sort-vowels-in-a-string/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой пузырьком!) numbers
         */
        int len = numbers.size();
        while (len > 1) {
            int swaps = 0;
            for (int i = 0; i < len - 1; ++i) {
                int j = i + 1;
                if (numbers.get(i) > numbers.get(j)) {
                    swaps += 1;
                    int tmp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, tmp);
                }
            }
            if (swaps == 0) {
                return numbers;
            }
            len -= 1;
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
