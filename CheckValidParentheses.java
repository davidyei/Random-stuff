/*
Leetcode problem: 
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

This is a solution to the above problem (isValid method) using Stack.
*/

import java.util.Stack;

public class Solution {

    private Stack<Character> parentheses = new Stack();
    private boolean Valid = false;

    public boolean isValid(String s) {
        if(s.length() == 0) return true;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                parentheses.push(s.charAt(i));
            } else if((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
                    && !parentheses.isEmpty()) {
                if(isSameType(parentheses.pop(), s.charAt(i))) Valid = true;
                else return false;
            } else {
                return false;
            }
        }
        if(Valid && parentheses.isEmpty()) return true;
        else return false;
    }

    private boolean isSameType(char open, char close){
        if(open == '(' && close == ')') return true;
        else if(open == '[' && close == ']') return true;
        else if(open == '{' && close == '}') return true;
        else return false;
    }
    
    public static void main(String[] args) {
       Solution test = new Solution();
       String subject = "[(}]";
       System.out.print(test.isValid(subject));
    }
}
