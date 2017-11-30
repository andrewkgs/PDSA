import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Search {
    private final static int VH_length = 10;
    private final static int Dia_length = 14;

    private MinPQ<Node> openSet;
    private Node[][] grid;

    private void update(Node current, Node another, boolean flag) {

        int d;
        if (flag) d = VH_length;
        else d = Dia_length;

        int new_g;
        if (another.state != 2 && another.h != -1) {
            new_g = current.g + d;
            if (new_g < another.g) {
                another.previous = current;
                another.g = new_g;
                another.f = another.g + another.h;
            }

            if (another.state == 0) {
                openSet.insert(another);
                another.state = 1;
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

        update(node, Right, true);
        update(node, LowerRight, false);
        update(node, Down, true);
        update(node, LowerLeft, false);
        update(node, Left, true);
        update(node, UpperLeft, false);
        update(node, Up, true);
        update(node, UpperRight, false);
    }

    private void AStarSearch(int total_row, int total_col, int start_row, int start_col, int goal_row, int goal_col, int[][] grid_h) {

        grid = new Node[total_row][total_col];
        openSet = new MinPQ<>();
        Stack<Node> closedSet = new Stack<>();

        for (int i=0; i<total_row; i++) {
            for (int j=0; j<total_col; j++) {
                Node node = new Node();
                node.row = i;
                node.col = j;
                node.state = 0;
                node.g = Integer.MAX_VALUE;
                node.h = grid_h[i][j];
                grid[i][j] = node;
            }
        }

        grid[start_row][start_col].g = 0;
        grid[start_row][start_col].f = grid[start_row][start_col].h;
        openSet.insert(grid[start_row][start_col]);

        while (!openSet.isEmpty()) {
            Node node = openSet.delMin();

            if (node.equals(grid[goal_row][goal_col])) {
                StdOut.println(node.f);
                Node trace = node;
                while (true) {
                    closedSet.push(trace);
                    trace = trace.previous;
                    if (trace == null) break;
                }

                while (!closedSet.isEmpty()) {
                    Node path = closedSet.pop();
                    StdOut.print(path.row + 1);
                    StdOut.print(",");
                    StdOut.println(path.col + 1);
                }
            }
            node.state = 2; // Add the node to closesSet
            observe(node);
        }
    }

    public static void main(String args[]) throws Exception{

        if (args.length != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                int total_row = Integer.parseInt(br.readLine().split(" ")[1]);
                int total_col = Integer.parseInt(br.readLine().split(" ")[1]);

                String start[] = br.readLine().split(" ")[1].split(",");
                int start_row = Integer.parseInt(start[0]) - 1;
                int start_col = Integer.parseInt(start[1]) - 1;

                String goal[] = br.readLine().split(" ")[1].split(",");
                int goal_row = Integer.parseInt(goal[0]) - 1;
                int goal_col = Integer.parseInt(goal[1]) - 1;

                int[][] grid_h = new int[total_row][total_col];

                for (int i=0; i<total_row; i++) {
                    String data[] = br.readLine().split(" ");
                    for (int j=0; j<total_col; j++) {
                        if (data[j].equals("nn")) grid_h[i][j] = -1;
                        else grid_h[i][j] = Integer.parseInt(data[j]);
                    }
                }

                Search search = new Search();
                search.AStarSearch(total_row, total_col, start_row, start_col, goal_row, goal_col, grid_h);
            }
        }
    }
}

class Node implements Comparable<Node> {
    public int row, col, f, g, h; // f = g + h
    public int state = 0; // unreached:0, in openSet:1, in closedSet:2
    public Node previous;

    public int compareTo(Node that) {
        if (this.f > that.f) return 1;
        else if (this.f < that.f) return -1;
        else if (this.h > that.h) return 1;
        else if (this.h < that.h) return -1;
        else return 0;
    }
}