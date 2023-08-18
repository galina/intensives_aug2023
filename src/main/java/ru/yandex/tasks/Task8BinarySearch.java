// Extra task https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package ru.yandex.tasks;

public class Task8BinarySearch {
    public static int find(int number, int[] sortedList) {
        /*
         * number: целое число, -10^5 <= number <= 10^5
         * numbers: массив целых чисел, 0 <= numbers.length <= 10^5
         * Выход: i, где numbers[i] = number, -1, если такого i нет
         * Если таких i несколько, вывести наибольший
         */
        int l = 0, r = sortedList.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (sortedList[mid] == number) {
                l = mid;
            } else if (sortedList[mid] < number) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (sortedList[l] != number)
            return -1;
        return l;
    }

    public static void selfCheck() {
        int[] input = {1, 3, 5, 7, 9};

        for (int i = 0; i < input.length; i++) {
            assert (find(input[i], input) == i);
        }
    }
}
