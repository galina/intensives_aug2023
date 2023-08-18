// Extra task https://leetcode.com/problems/find-the-value-of-the-partition/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой вставками!) numbers
         */
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < numbers.size(); ++i) {
            // вставить numbers.get(i) в нужную позицию в output
            for (int j = 0; j < output.size(); ++j) {
                int elem = numbers.get(i);
                if (output.get(j) >= elem) {
                    output.add(j, elem);
                }
            }
        }
        return output;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
