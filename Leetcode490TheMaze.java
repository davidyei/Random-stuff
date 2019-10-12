/*
DFS solution to the problem below:

There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.
*/

class Solution {
    int goalX;
    int goalY;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        goalX = destination[0];
        goalY = destination[1];
        int x = start[0];
        int y = start[1];
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        boolean result = false;

        if(pathFinding(maze, new int[]{x - 1, y}, 'u', visited)) return true;
        if(pathFinding(maze, new int[]{x + 1, y}, 'd', visited)) return true;
        if(pathFinding(maze, new int[]{x, y - 1}, 'l', visited)) return true;
        if(pathFinding(maze, new int[]{x, y + 1}, 'r', visited)) return true;
        return false;
    }

    //direction: 'u' = up, 'd' = down, 'l' = left, 'r' = right
    private boolean pathFinding (int[][] maze, int[] current, char direction, boolean[][] visited) {
        int x = current[0];
        int y = current[1];
        
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 1) {
            return false;
        }

        if(visited[x][y]) {
            return false;
        }

        if (x == goalX && y == goalY) {
            System.out.println("here, dir: " + direction);
            if(existWall(x, y, maze, direction)) {
                            System.out.println("here, dir: " + direction);
                            return true;

            }
        }

        if (direction == 'u' && x - 1 >= 0 && maze[x - 1][y] != 1) { //Check of the direction ball is going has no wall
            if(pathFinding(maze, new int[]{x - 1, y}, 'u', visited)) return true;
        } else if (direction == 'u' && (x - 1 < 0 || maze[x - 1][y] == 1)) {//Check if the direction ball is going has wall, then change direction
            visited[x][y] = true;
            if(pathFinding(maze, new int[]{x, y - 1}, 'l', visited)) return true;
            if(pathFinding(maze, new int[]{x, y + 1}, 'r', visited)) return true;
        }
        if (direction == 'd' && x + 1 < maze.length && maze[x + 1][y] != 1) {
            if(pathFinding(maze, new int[]{x + 1, y}, 'd', visited)) return true;
        } else if (direction == 'd' && (x + 1 == maze.length || maze[x + 1][y] == 1)) {
            visited[x][y] = true;
            if(pathFinding(maze, new int[]{x, y - 1}, 'l', visited)) return true;
            if(pathFinding(maze, new int[]{x, y + 1}, 'r', visited)) return true;
        }
        if (direction == 'l' && y - 1 >= 0 && maze[x][y - 1] != 1) {
            if(pathFinding(maze, new int[]{x, y - 1}, 'l', visited)) return true;
        } else if (direction == 'l' && (y - 1 < 0 || maze[x][y - 1] == 1)) {
            visited[x][y] = true;
            if(pathFinding(maze, new int[]{x - 1, y}, 'u', visited)) return true;
            if(pathFinding(maze, new int[]{x + 1, y}, 'd', visited)) return true;
        }
        if (direction == 'r' && y + 1 < maze[0].length && maze[x][y + 1] != 1) {
            if(pathFinding(maze, new int[]{x, y + 1}, 'r', visited))return true;
        } else if (direction == 'r' && (y + 1 == maze[0].length || maze[x][y + 1] == 1)) {
            visited[x][y] = true;
            if(pathFinding(maze, new int[]{x - 1, y}, 'u', visited)) return true;
            if(pathFinding(maze, new int[]{x + 1, y}, 'd', visited)) return true;
        }
        return false;
    }

    private boolean existWall (int x, int y, int[][]maze, char dir) {
        if (dir == 'u') {
            if (x - 1 < 0 || maze[x - 1][y] == 1)
                return true;
        } else if (dir == 'd') {
            if (x + 1 == maze.length || maze[x + 1][y] == 1)
                return true;
        } else if (dir == 'l') {
            if (y - 1 < 0 || maze[x][y - 1] == 1)
                return true;
        } else if (dir == 'r') {
            if (y + 1 == maze[0].length || maze[x][y + 1] == 1)
                return true;
        }
        return false;
    }
}
