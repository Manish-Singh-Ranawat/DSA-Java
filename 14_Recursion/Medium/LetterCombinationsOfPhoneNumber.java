// Letter Combinations of a Phone Number - https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        getCombinations(0, digits.length(), digits, map, "", ans);
        return ans;
    }

    private static void getCombinations(int idx, int n, String digits, HashMap<Character, String> map, String s,
            List<String> ans) {
        if (idx == n) {
            ans.add(s);
            return;
        }
        String letters = map.get(digits.charAt(idx));
        for (char ch : letters.toCharArray()) {
            getCombinations(idx + 1, n, digits, map, s + ch, ans);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
        // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
