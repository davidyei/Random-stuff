import java.util.Queue;

public class Solution {

    public Solution (){};

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

        for(int i = 0; i < Grid.length; i ++){
            for(int j = 0; j < Grid[0].length; j++){
                if(Visited[i][j] == false && Grid[i][j] == '1'){
                    findOneIsland(i, j, 0);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean findOneIsland(int i, int j, int k){
        Visited[i][j] = true;
        if(j + 1 < Grid[0].length && Visited[i][j + 1] == false && Grid[i][j + 1] == '1') findOneIsland(i, j + 1, k + 1);
        if(j - 1 >= 0 && Visited[i][j - 1] == false && Grid[i][j - 1] == '1') findOneIsland(i, j - 1, k + 1);
        if(i + 1 < Grid.length && Visited[i + 1][j] == false && Grid[i + 1][j] == '1') findOneIsland(i + 1, j, k + 1);
        if(i - 1 >= 0 && Visited[i - 1][j] == false && Grid[i - 1][j] == '1') findOneIsland(i - 1, j, k + 1);
        return true;
    }
}
