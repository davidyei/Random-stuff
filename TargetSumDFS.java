/*
Leetcode problem:
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. 
For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Below is a DFS recursive solution to the problem above.
 */

public class Solution {
    int [] numbers;
    int ways = 0;
    int target;

    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        numbers = nums;
        target = S;
        DFS(1, nums[0]);
        DFS(1, - nums[0]);

        return ways;
    }

    private void DFS(int index, int previousSum){
        if(index == numbers.length) {
            if(previousSum == target) {
                ways += 1;
            }
        } else {
            DFS(index + 1, previousSum + numbers[index]); //Add
            DFS(index + 1, previousSum - numbers[index]); //Subtract
        }
    }
}
