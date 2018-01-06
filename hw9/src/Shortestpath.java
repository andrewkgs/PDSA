public class Shortestpath {

    private final static int VH_length = 10;
    private final static int Dia_length = 14;

    private MinPQ<Node> openSet;
    private Node[][] grid;

    private void update(Node current, Node another, boolean flag) {
        int d;
        if (flag) d = VH_length;
        else d = Dia_length;

        int new_g;
        if (another.state != 2) {
            new_g = current.g + d;
            if (new_g < another.g) {
                another.previous = current;
                another.g = new_g;
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

    public Shortestpath (int[] total, int[] start, int[] goal, int[][] dist) {
        openSet = new MinPQ<>();
        grid = new Node[total[0]][total[1]];

        for (int i=0; i<total[0]; i++) {
            for (int j=0; j<total[1]; j++) {
                Node node = new Node();
                node.row = i;
                node.col = j;
                if (dist[i][j] == -1) node.state = 2;
                else node.state = 0;
                node.g = Integer.MAX_VALUE;
                grid[i][j] = node;
            }
        }
        // start point
        grid[start[0]][start[1]].g = 0;
        openSet.insert(grid[start[0]][start[1]]);

        while (!openSet.isEmpty()) {
            Node node = openSet.delMin();
            if (node.equals(grid[goal[0]][goal[1]])) StdOut.println(node.g);
            else {
                node.state = 2;
                observe(node);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            In in = new In(args[0]);
            int[] total = new int[2];
            total[0] = Integer.parseInt(in.readLine().split(" ")[1]);
            total[1]= Integer.parseInt(in.readLine().split(" ")[1]);

            String data;
            data = in.readLine();
            int[] start = new int[2];
            start[0] = Integer.parseInt(data.split(" ")[1].split(",")[0]) - 1;
            start[1] = Integer.parseInt(data.split(" ")[1].split(",")[1]) - 1;

            data = in.readLine();
            int[] goal = new int[2];
            goal[0] = Integer.parseInt(data.split(" ")[1].split(",")[0]) - 1;
            goal[1] = Integer.parseInt(data.split(" ")[1].split(",")[1]) - 1;

            in.readLine();

            int dist[][] = new int[total[0]][total[1]];

            for (int i=0; i<total[0]; i++) {
                dist[i][0] = -1;
                dist[i][total[1]-1] = -1;
            }
            for (int i=0; i<total[1]; i++) {
                dist[0][i] = -1;
                dist[total[0]-1][i] = -1;
            }

            int block_row, block_col;
            while ((data=in.readLine()) != null) {
                block_row = Integer.parseInt(data.split(",")[0]) - 1;
                block_col = Integer.parseInt(data.split(",")[1]) - 1;
                dist[block_row][block_col] = -1;
            }

            Shortestpath sp = new Shortestpath(total, start, goal, dist);
        }
    }
}

class Node implements Comparable<Node> {
    public int row, col, g;
    public int state = 0; // unreached:0, in openSet:1, in closedSet:2
    public Node previous;

    public int compareTo(Node that) {
        if (this.g > that.g) return 1;
        else if (this.g < that.g) return -1;
        else return 0;
    }
}