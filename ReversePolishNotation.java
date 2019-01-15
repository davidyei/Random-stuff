/*
Leetcode problem: 

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. 
That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Below is a solution (evalRPN method) using stack to the problem
 */

import java.util.Stack;

public class Solution {

    private Stack<Integer> stack = new Stack<Integer>();

    public int evalRPN(String[] tokens) {

        if(tokens.length == 0) return 0;

        for(String a : tokens){
            if(isNum(a)){
                stack.push(new Integer(String.valueOf(a)));
            } else {
                int i = stack.pop();
                int j = stack.pop();
                stack.push(calculate(j, i, a));
            }
        }
        if(stack.size() == 1) {
            return stack.pop();
        } else return 0;
    }

    private boolean isNum(String a){
        if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/")) {
            return false;
        } else return true;
    }

    private int calculate(int a, int b, String c){
        if(c.equals("+")){
            return a + b;
        } else if(c.equals("-")){
            return a - b;
        } else if(c.equals("*")){
            return a * b;
        } else {
            return a / b;
        }
    }
}
