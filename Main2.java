/**
 * Copyright (c) 2023 Drishti-Soft Solutions Pvt. Ltd.
 *
 * @author: nikhilsrivastava
 * Date:  Nov 8, 2023
 */
package com.ameyo.configuration.services.dagenturiresolver;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Main2 {

    public Set<String> longestPalindromicSubstrings(String string) {
        String processedString = preprocessString(string);
        if (processedString == null || processedString.length() < 1) {
            return new HashSet<>();
        }
        Set<String> result = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < processedString.length(); i++) {
            int len1 = expandAroundCenter(processedString, i, i);
            int len2 = expandAroundCenter(processedString, i, i + 1);
            int len = Math.max(len1, len2);
            if (len >= maxLength) {
                if (len > maxLength) {
                    maxLength = len;
                    result.clear();
                }
                if (len % 2 == 0) {
                    //result.add(processedString.substring(i - len / 2 + 1, i + len / 2 + 1));
                    int x = i - len / 2 + 1, y = i + len / 2 + 1;
                    String ss = get(x, y, string, len);
                    result.add(ss);
                } else {
                    //result.add(processedString.substring(i - len / 2, i + len / 2 + 1));
                    int x = i - len / 2, y = i + len / 2 + 1;
                    String ss = get(x, y, string, len);
                    result.add(ss);
                }
            }

        }

        return result;
    }

    private String get(int x, int y, String string, int len) {
        int count = 0, charCount = 0, index = 0;
        StringBuilder sh = new StringBuilder();
        if (x > 0) {
            for (int i = 0; i < string.length(); i++) {
                index = i;
                if (Character.isLetterOrDigit(string.charAt(i))) {
                    charCount++;
                }
                if (charCount == x + 1) {
                    break;
                }
            }
            for (int i = index; i < string.length(); i++) {
                if (Character.isLetterOrDigit(string.charAt(i))) {
                    count++;
                }
                sh.append(string.charAt(i));
                if (count >= len) {
                    break;
                }
            }
        } else {
            for (int i = x; i < string.length(); i++) {
                if (Character.isLetterOrDigit(string.charAt(i))) {
                    count++;
                }
                sh.append(string.charAt(i));
                if (count >= len) {
                    break;
                }
            }
        }
        return sh.toString().trim();
    }

    private String preprocessString(String string) {
        StringBuilder sb = new StringBuilder();
        for (char c : string.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private boolean isPalindrome(String input) {

        String processedString = preprocessString(input);
        if (processedString.isEmpty()) {
            return false;
        }
        boolean alphanumeric = false;
        int p1 = 0, p2 = processedString.length() - 1;
        while (p1 < p2) {
            alphanumeric = false;
            /*if (!Character.isLetterOrDigit(processedString.charAt(p1))) {
                p1++;
                alphanumeric = true;
            }
            if (!Character.isLetterOrDigit(processedString.charAt(p2))) {
                p2--;
                alphanumeric = true;
            }*/
            if (!alphanumeric) {
                if (processedString.charAt(p1) == processedString.charAt(p2)) {
                    p1++;
                    p2--;
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Main2 main = new Main2();
        String input = "R_ace%ca rs racing";//R_ace%ca rs racing, No lemon no melons, abcAb, Racecars racing, A Racecar reviver, A racecar, A Racecar Aaaaaaa,  Ra_c#eca rs racing, A Racecar Aaaaaa
        Set<String> result = main.longestPalindromicSubstrings(input);
        System.out.println("pehla case " + input + " " + main.isPalindrome(input));
        System.out.println(result);
    }

}
