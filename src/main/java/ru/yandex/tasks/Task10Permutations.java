package ru.yandex.tasks;

import java.util.Arrays;
import java.util.ArrayList;

public class Task10Permutations {
    public static int[][] permutations(int[] numbers) {
        /*
         * Возвращает массив со всеми перестановками массива numbers (массив n чисел от 1 до n, 1 <= n <= 10)
         */
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < numbers.length; ++i) {
            ArrayList<Integer> current = new ArrayList<>();
            current.add(numbers[i]);
            permuteNums(numbers, permutations, current);
        }

        int[][] result = new int[permutations.size()][numbers.length];
        for (int i = 0; i < permutations.size(); ++i) {
            ArrayList<Integer> ith_permutation = permutations.get(i);
            int[] datai = new int[numbers.length];
            for (int j = 0; j < ith_permutation.size(); ++j) {
                datai[j] = ith_permutation.get(j);
            }
            result[i] = datai;
        }

        return result;
    }

    public static void permuteNums(int[] nums, ArrayList<ArrayList<Integer>> permutations, ArrayList<Integer> current) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!current.contains(nums[i])) {
                current.add(nums[i]);
                permuteNums(nums, permutations, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void selfCheck() {
        int[] input = {1, 2, 3};
        int[][] output = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };

        assert Arrays.deepEquals(output, permutations(input));
    }
}
