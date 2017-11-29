import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Search {
    private final static int VH_length = 10;
    private final static int Dia_length = 14;

    public class Node implements Comparable<Node> {
        public int row, col, f, g, h; // f = g + h
        private int state = 0; // unreached:0, in openSet:1, in closedSet:2
        public Node previous;

        public int compareTo(Node that) {

            this.f = this.g + this.h;
            that.f = that.g + that.h;

            if (this.f > that.f) return 1;
            else if (this.f == that.f) {
                if (this.h > that.h) return 1;
                else if (this.h == that.h) return 0;
            }
            return -1;
        }
    }

    public MinPQ<Node> openSet = new MinPQ<>();
    public Stack<Node> closedSet = new Stack<>();
    public Node[][] grid;
    

    private void update(Node node, boolean flag) {

        int d;
        if (flag) d = VH_length;
        else d = Dia_length;

        int new_g;
        if (node.state != 2 && node.h != -1) {
            new_g = node.g + d;
            if (new_g < node.g) {
                node.previous = node;
                node.g = new_g;
            }

            if (node.state == 0) {
                openSet.insert(node);
                node.state = 1;
            }
        }
    }


    private void observe(Node node) {

        // Observe order: Right, LowerRight, Down, LowerLeft, Left, UpperLeft, Up, UpperRight

        Node Right = grid[node.row][node.col + 1];
        Node LowerRight = grid[node.row + 1][node.col + 1];
        Node Down = grid[node.row + 1][node.col];
        Node LowerLeft = grid[node.row + 1][node.col - 1];
        Node Left = grid[node.row][node.col - 1];
        Node UpperLeft = grid[node.row - 1][node.col - 1];
        Node Up = grid[node.row - 1][node.col];
        Node UpperRight = grid[node.row - 1][node.col + 1];

        update(Right, true);
        update(LowerRight, false);
        update(Down, true);
        update(LowerLeft, false);
        update(Left, true);
        update(UpperLeft, false);
        update(Up, true);
        update(UpperRight, false);
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

                int[][] grid_h = new int[total_row][total_col];

                for (int i=0; i<total_row; i++) {
                    String data[] = br.readLine().split(" ");
                    for (int j=0; j<total_col; j++) {
                        if (data[j].equals("nn")) grid_h[i][j] = -1;
                        else grid_h[i][j] = Integer.parseInt(data[j]);
                    }
                }

                for (int i=0; i<total_row; i++) {
                    for (int j=0; j<total_col; j++) {
                        Node node = new Node();
                    }
                }
            }
        }
    }
}