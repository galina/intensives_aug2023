// Extra task https://leetcode.com/problems/valid-parentheses/

package ru.yandex.tasks;

import java.util.Stack;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        /*
         * sequence - последовательность скобок []{}() длины до 10^5
         * Выход: true/false, является ли строка ПСП
         */
        String[] parts = s.split("");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals("(") || part.equals("{") || part.equals("[")) {
                stack.push(part);
                continue;
            }
            if (stack.isEmpty())
                return false;
            if (part.equals(")")) {
                if (!stack.pop().equals("("))
                    return false;
            }
            if (part.equals("}")) {
                if (!stack.pop().equals("{"))
                    return false;
            }
            if (part.equals("]")) {
                if (!stack.pop().equals("["))
                    return false;
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
