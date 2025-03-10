// Count With K Different Characters - https://www.naukri.com/code360/problems/count-with-k-different-characters_1214627?leftPanelTabValue=PROBLEM

// You are given a string 'str' of lowercase alphabets and an integer 'k' .

// Your task is to return the count all the possible substrings that have exactly 'k' distinct characters.

// Input : str = "aacfssa", k =3
// Output : 5    
// Explanation : Given 'str' = “aacfssa”. We can see that the substrings with only 3 distinct characters are {aacf, acf, cfs, cfss, fssa}. 
// Therefore, the answer will be 5.

import java.util.HashMap;

public class CountSubstringsWithKDifferentCharacters {
    public static int countSubStrings(String str, int k) {
        int totalSubstrings = countSubstringsWithAtMostKDistinct(str, k)
                - countSubstringsWithAtMostKDistinct(str, k - 1);
        return totalSubstrings;
    }

    public static int countSubstringsWithAtMostKDistinct(String s, int k) {
        if (k <= 0) {
            return 0;
        }
        int n = s.length();
        int l = 0;
        int r = 0;
        int subStringsCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            while (map.size() > k) {
                char lChar = s.charAt(l);
                if (map.get(lChar) == 1) {
                    map.remove(lChar);
                } else {
                    map.put(lChar, map.get(lChar) - 1);
                }
                l++;
            }
            if (map.size() <= k) {
                subStringsCount += r - l + 1;
            }
            r++;
        }
        return subStringsCount;
    }

    public static void main(String[] args) {
        String str = "aacfssa";
        int k = 3;
        System.out.println(countSubStrings(str, k));
        // 5
    }
}
