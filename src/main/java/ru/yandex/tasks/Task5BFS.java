// Extra task https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

package ru.yandex.tasks;

import java.util.Arrays;
import java.util.ArrayDeque;

public class Task5BFS {
    public static void runSearch() {
        /*
         * Реализация bfs
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
    }

    public static int[] getBFSOrder(int[][] tree, int root) {
        /*
         * Функция возвращает массив с порядковыми номерами вершин в обходе
         * Дано дерево из n (<= 10^5) вершин (пронумерованных от 0 до n-1)
         * tree - двумерный массив, tree[i][0] - номер левого сына, tree[i][1] - номер правого сына (если нет левого / правого сына, соотв. элемент -1).
         * root - корень, откуда нужно начинать обход
         */
        int[] result = new int[tree.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(root);
        int pos = 0;
        while (!queue.isEmpty()) {
            int elem = queue.pop();
            result[pos] = elem;
            if (tree[elem][0] != -1)
                queue.push(tree[elem][0]);
            if (tree[elem][1] != -1)
                queue.push(tree[elem][1]);
            pos += 1;
        }
        return result;
    }

    public static void selfCheck() {
        int[][] tree =
                {
                        {1, 6},
                        {2, 3},
                        {-1, -1},
                        {4, -1},
                        {-1, -1},
                        {-1, -1},
                        {-1, 8},
                        {-1, -1},
                        {-1, -1}
                };

        int[] ans1 = {0, 1, 6, 2, 3, 8, 4};
        int[] ans2 = {3, 4};
        int[] ans3 = {2};
        int[] ans4 = {6, 8};

        assert (Arrays.equals(getBFSOrder(tree, 0), ans1));
        assert (Arrays.equals(getBFSOrder(tree, 3), ans2));
        assert (Arrays.equals(getBFSOrder(tree, 2), ans3));
        assert (Arrays.equals(getBFSOrder(tree, 6), ans4));
    }
}
