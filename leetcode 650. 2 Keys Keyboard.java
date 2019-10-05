/*
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
 

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
Output the minimum number of steps to get n 'A'.
*/

public class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;

        return Integer.min(minStepsHelper(n, 2, 1, 2), minStepsHelper(n, 2, 2, 3));
    }

    int minStepsHelper(int target, int current, int copy, int steps) {
        if (current > target) {
            return Integer.MAX_VALUE;
        } else if (current == target) {
            return steps;
        } else {
            return Integer.min(minStepsHelper(target, current + copy, copy, steps + 1),//copy from previous
                    minStepsHelper(target, current * 2, current, steps + 2));//creating new copy
        }
    }
}
