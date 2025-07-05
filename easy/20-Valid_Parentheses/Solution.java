/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.
 */


import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    stack.push(s.charAt(0));
    for(int i=1;i<s.length();i++){
      if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
        stack.push(s.charAt(i));
      }
      else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
        stack.pop();
      }
      else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
        stack.pop();
      }
      else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
        stack.pop();
      }
      else{
        stack.push(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }
}