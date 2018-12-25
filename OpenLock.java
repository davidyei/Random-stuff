import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    private boolean Visited[][][][] = new boolean[10][10][10][10];
    Queue <Node> Combos = new LinkedList<Node>();
    private int Target;
    private int [] Deadends;

    public Solution(){};

    public int openLock(String[] deadends, String target) {
        for(String a : deadends){
            if(a.equals("0000")) return -1;
        }

        for(int i = 0; i <= 9; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k <= 9; k++){
                    for(int q = 0; q <= 9; q++){
                        Visited[i][j][k][q] = false;
                    }
                }
            }
        }

        Target = Integer.parseInt(target);
        Deadends = new int[deadends.length];

        for(int i = 0; i < deadends.length; i++){
            Deadends[i] = Integer.parseInt(deadends[i]);
        }

        return this.findTarget();

    }

    private int findTarget(){
        Visited[0][0][0][0] = true;
        Node startNode = new Node(0, 0, 0, 0, 0);
        Combos.add(startNode);

        while(Combos.size() != 0) {
            Node current = Combos.poll();
            int dig1 = current.getDig1();
            int dig2 = current.getDig2();
            int dig3 = current.getDig3();
            int dig4 = current.getDig4();
            int level = current.getLevel();

            if (addNode(dig1 + 1, dig2, dig3, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1 - 1, dig2, dig3, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2 + 1, dig3, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2 - 1, dig3, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2, dig3 + 1, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2, dig3 - 1, dig4, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2, dig3, dig4 + 1, level) != -1)
                return level + 1;

            if (addNode(dig1, dig2, dig3, dig4 - 1, level) != -1)
                return level + 1;
        }
        return -1;
    }


    private int addNode(int a, int b, int c, int d, int level) {
        a = convert(a);
        b = convert(b);
        c = convert(c);
        d = convert(d);

        if (Visited[a][b][c][d] == false) {
            if (a * 1000 + b * 100 + c * 10 + d == Target) {
                return level + 1;
            } else if (checkDeadEnd(a, b, c, d)) {
                Visited[a][b][c][d] = true;
            } else {
                Visited[a][b][c][d] = true;
                Combos.add(new Node(a, b, c, d, level + 1));
            }
            return -1;
        }
        return -1;
    }


    private int convert(int i){
        if(i == -1) return 9;
        else if(i == 10) return 0;
        else return i;

    }

    private boolean checkDeadEnd(int a, int b, int c, int d) {
        for (int deadends : Deadends) {
            if (a * 1000 + b * 100 + c * 10 + d == deadends)
                return true;
        }
        return false;
    }

    private class Node {

        int dig1;
        int dig2;
        int dig3;
        int dig4;
        int level;

        public Node(int a, int b, int c, int d, int e) {
            dig1 = a;
            dig2 = b;
            dig3 = c;
            dig4 = d;
            level = e;
        }

        public int getDig1() {
            return dig1;
        }

        public int getDig2() {
            return dig2;
        }

        public int getDig3() {
            return dig3;
        }

        public int getDig4() {
            return dig4;
        }

        public int getLevel() {
            return level;
        }
    }
}
