/*
Leetcode problem:
Given the head of a graph, return a deep copy (clone) of the graph. 
Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. 
There is an edge between the given node and each of the nodes in its neighbors.

Below is a solution using DFS recursion and HashMap
*/

import java.util.HashMap;

public class Solution {

    HashMap<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        int currentLabel = node.label;
        if(visited.get(currentLabel) != null) {
            return visited.get(currentLabel);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(currentLabel);
        visited.put(currentLabel, copy);

        for(UndirectedGraphNode next : node.neighbors){
                UndirectedGraphNode nextCopy = cloneGraph(next);
                copy.neighbors.add(nextCopy);
        }
        return copy;
    }
}
