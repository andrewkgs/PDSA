import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Search {
    private final static int VH_length = 10;
    private final static int Dia_length = 14;

    public class Node implements Comparable<Node> {
        public int x_co, y_co, f, g, h; // f = g + h
        public int state = 0; // unreached:0, in openSet:1, in closedSet:2
        public Node previous;

        public int compareTo(Node that) {

            this.f = this.g + this.h;
            that.f = that.g + that.h;

            if (this.f > that.f) return 1;
            else if (this.f == that.f) {
                if (this.h > that.h) return 1;
                else if (this.h == that.h) return 0;
            }
            else return -1;
        }
    }

    private MinPQ<Node> openSet;
    private Stack<Node> closedSet;

    private Node[][]

    private void observe(Node node) {
        // Observe order: Right, LowerRight, Down, LowerLeft, Left, UpperLeft, Up, UpperRight


    }

    public static void main(String args[]) throws Exception{
        if (args.length != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                int total_row = Integer.parseInt(br.readLine().split(" ")[1]);
                int total_col = Integer.parseInt(br.readLine().split(" ")[1]);

                String start[] = br.readLine().split(" ")[1].split(",");
                int start_row = Integer.parseInt(start[0]) - 1;
                int start_col = Integer.parseInt(start[1]) - 1;
                start = null;

                String goal[] = br.readLine().split(" ")[1].split(",");
                int goal_row = Integer.parseInt(goal[0]) - 1;
                int goal_col = Integer.parseInt(goal[1]) - 1;
                goal = null;

                int[][] field = new int[total_row][total_col];

                for (int i=0; i<total_row; i++) {
                    String data[] = br.readLine().split(" ");
                    for (int j=0; j<total_col; j++) {
                        if (data[j].equals("nn")) field[i][j] = -1;
                        else field[i][j] = Integer.parseInt(data[j]);
                    }
                }
                Search search = new Search();

            }
        }
    }
}