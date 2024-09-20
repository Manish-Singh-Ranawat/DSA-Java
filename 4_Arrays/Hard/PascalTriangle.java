// Pascal's Triangle - https://leetcode.com/problems/pascals-triangle/

// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            pascal.add(generateRow(row));
        }
        return pascal;
    }

    public static List<Integer> generateRow(int row) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        int num = 1;
        for (int col = 1; col < row; col++) {
            num = num * (row - col);
            num = num / col;
            temp.add(num);
        }
        return temp;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
