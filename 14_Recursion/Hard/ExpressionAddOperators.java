// Expression Add Operators - https://leetcode.com/problems/expression-add-operators/description/

// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

// Note that operands in the returned expressions should not contain leading zeros.

// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0)
            return ans;
        solve(0, "", 0, 0, num, target, ans);
        return ans;
    }

    private static void solve(int index, String path, long resSoFar, long prevNum, String num, int target,
            List<String> ans) {
        if (index == num.length()) {
            if (resSoFar == target)
                ans.add(path);
            return;
        }
        for (int j = index; j < num.length(); j++) {
            if (j > index && num.charAt(index) == '0')
                break;
            long currNum = Long.parseLong(num.substring(index, j + 1));
            if (index == 0) {
                solve(j + 1, path + currNum, currNum, currNum, num, target, ans);
            } else {
                solve(j + 1, path + "+" + currNum, resSoFar + currNum, currNum, num, target, ans);
                solve(j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, num, target, ans);
                solve(j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, num,
                        target, ans);
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));
        // [1+2+3, 1*2*3]
    }
}
