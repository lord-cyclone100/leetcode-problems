/*

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase English letters.

*/

import java.util.Arrays;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] res = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        for(int i=0;i<l1;i++){
            int idx = s1Array[i] - 'a';
            freq[idx]++;
        }
        for(int i=0;i<=(l2-l1);i++){
            for(int j=i;j<(i+l1);j++){
                int idx = s2Array[j] - 'a';
                res[idx]++;
            }
            if(Arrays.equals(res,freq)){
                return true;
            }
            res = new int[26];
        }
        return false;
    }
}