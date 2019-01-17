import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    public Solution (){};

    Queue <Node> Island = new LinkedList<Node>();
    char [][] Grid;
    boolean [][] Visited;
    private int count = 0;

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        Grid = grid;
        for(int i = 0; i < Grid.length; i ++){
            for(int j = 0; j < Grid[0].length; j++){
                Grid[i][j] = grid[i][j];
            }
        }

        Visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < Visited.length; i ++){
            for(int j = 0; j < Visited[0].length; j++){
                Visited[i][j] = false;
            }
        }

        for(int i = 0; i < Grid.length; i++){
            for(int j = 0; j < Grid[0].length; j++){
                if(Visited[i][j] == false && Grid[i][j] == '1'){
                    findOneIsland(i, j, 0);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findOneIsland(int a, int b, int c){
        Visited[a][b] = true;
        Node startNode = new Node(a, b, c);
        Island.add(startNode);

        while(Island.size() != 0){
            Node current = Island.poll();
            int i = current.getRow();
            int j = current.getColumn();
            int k = current.getLevel();

            if(j + 1 < Grid[0].length && Visited[i][j + 1] == false && Grid[i][j + 1] == '1'){
                Island.add(new Node(i, j + 1, k + 1));
                Visited[i][j + 1] = true;
            }
            if(j - 1 >= 0 && Visited[i][j - 1] == false && Grid[i][j - 1] == '1'){
                Island.add(new Node(i, j - 1, k + 1));
                Visited[i][j - 1] = true;
            }
            if(i + 1 < Grid.length && Visited[i + 1][j] == false && Grid[i + 1][j] == '1') {
                Island.add(new Node(i + 1, j, k + 1));
                Visited[i + 1][j] = true;
            }
            if(i - 1 >= 0 && Visited[i - 1][j] == false && Grid[i - 1][j] == '1'){
                Island.add(new Node(i - 1, j, k + 1));
                Visited[i - 1][j] = true;
            }
        }
        return true;
    }

    private class Node{
        int row;
        int column;
        int level;

        public Node (int i, int j, int k){
            row = i;
            column = j;
            level = k;
        }

        public int getRow(){
            return row;
        }

        public int getColumn(){
            return column;
        }

        public int getLevel(){
            return level;
        }

    }
}
