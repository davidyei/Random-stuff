/*
Leetcode problem:
A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.
*/

class Solution {
    public int maxTurbulenceSize(int[] A) {
        if(A == null) return 0;
        if(A.length <=2 ) return A.length;

        int count = 0;
        int max = 0;

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 1] && A[i + 1] < A[i + 2]) {
                count++;
            } else if (A[i] < A[i + 1] && A[i + 1] > A[i + 2]) {
                count++;
            } else {
                count = 0;
            }
            if(count > max) max = count;
        }
        return (max + 2);
    }
}
