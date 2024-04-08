/**
 * Copyright (c) 2023 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: nikhilsrivastava
 * Date:  Dec 29, 2023
 */
package com.ameyo.configuration.services.dagenturiresolver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LargeNoAddition {
    private static boolean formattingFlag = true;

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        String num1 = "8,944,394,323,791,464";
        String num2 = "14,472,334,024,676,221";
        String sum = addStrings(num1, num2);
        int fibNum = 31;
        String fibb = fibonacci(fibNum);//baad me krna hai
        System.out
                .println("Sum of " + num1 + " and " + num2 + " is:->" + sum + " and fib of " + fibNum + " is->" + fibb);
    }

    public static String addStrings(String num1, String num2) {
        num1 = num1.replaceAll(",", "");
        num2 = num2.replaceAll(",", "");
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        if (formattingFlag) {
            return getFormattedResult(result).toString();
        }

        return result.toString();
    }

    private static StringBuilder getFormattedResult(StringBuilder result) {
        StringBuilder formattedResult = new StringBuilder();
        for (int k = result.length() - 1, l = 0; k >= 0; k--, l++) {
            if (l > 0 && l % 3 == 0) {
                formattedResult.insert(0, ',');
            }
            formattedResult.insert(0, result.charAt(k));
        }
        return formattedResult;
    }

    public static String fibonacci(int n) {

        if (n <= 2) {
            return "1";
        }

        List<String> fibList = new ArrayList<>();
        fibList.add("1");
        fibList.add("1");
        for (int i = 2; i < n; i++) {
            fibList.add(addStrings(fibList.get(i - 2), fibList.get(i - 1)));
        }
        return fibList.get(fibList.size() - 1);
    }

}
