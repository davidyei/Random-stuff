/*
Leetcode Question: Given a positive integer n, find the least number of perfect 
square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

This is a BFS solution ( method numSquares(number) ) to the leetcode problem above
*/

import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    Queue <Node> queue = new LinkedList<Node>();
    int [] perfectSquares;

    public int numSquares(int n) {

        if(n <= 0) return 0;

        /*perfectSquares is an array that contains all the perfect squares
        that is less than n
         */
        perfectSquares = greatestPerfectSquare(n);

        Node startNode = new Node(0, 0);
        queue.add(startNode);

        while(queue.size() != 0) {
            Node current = queue.poll();
            int level = current.getLevel();
            int sum = current.getSum();

            for(int i = 0; i < perfectSquares.length; i++){
                if(sum + perfectSquares[i] < n){
                    queue.add(new Node(perfectSquares[i] + sum, level + 1));
                }
                else if(sum + perfectSquares[i] == n){
                    return level + 1;
                }
            }
        }
        return -1;
    }

    private int[] greatestPerfectSquare(int i){
        int k = 1;
        while(k*k <= i) {
            k++;
        }

        int [] a = new int[k - 1];

        for(int j = 1; j < k; j++){
            a[j - 1] = (k-j)*(k-j);
        }

        return a;

    }

    private class Node {

        int level;
        int sum;

        public Node(int Sum, int Level) {
            sum = Sum;
            level = Level;
        }

        public int getLevel() {
            return level;
        }
        public int getSum() {
            return sum;
        }

    }

}
