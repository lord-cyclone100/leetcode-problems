/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 10^4
s[i] is '(', or ')'.
 */


import java.util.Stack;

class Solution {
  public int longestValidParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    int arr[] = new int[s.length()];
    int curLength = 0;
    int maxLength = 0;
    if(s.length() == 0){
      return 0;
    }
    stack.push(s.charAt(0));
    for(int i=1;i<s.length();i++){
      if(s.charAt(i) == '('){
        stack.push(s.charAt(i));
      }
      else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
        stack.pop();
        arr[i] = 1;
        for(int j=i-1;j>=0;j--){
          if(arr[j] == 0){
            arr[j] = 1;
            break;
          }
        }
      }
      else{
        stack.push(s.charAt(i));
      }
    }
    for(int i : arr){
      if(i == 1){
        curLength++;
        maxLength = Math.max(maxLength,curLength);
      }
      else{
        curLength = 0;
      }
    }
    return maxLength;
  }
}