import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Percolation{

    private int top = 0;
    private int bottom;
    private boolean[] grid_state; // The default is false.
    private WeightedQuickUnionUF wqf;

    public Percolation(int n){
        bottom = n*n + 1;
        grid_state = new boolean[n*n + 2];
        wqf = new WeightedQuickUnionUF(n*n + 2);
    }

    private int co_to_in(int n, int x, int y){ return n*(x-1)+y; }

    private int in_to_row(int n, int i){ return ((i-1)/n)+1; }

    private int in_to_col(int n, int row, int i){ return i-((row-1)*n); }

    private void open_grid(int i){ grid_state[i] = true; }

    private boolean is_open(int i){ return grid_state[i]; }

    private void connect(int n, int i){
        if ((in_to_row(n, i) == 1)){ wqf.union(top, i); } // first row
        else if (in_to_row(n, i) == n){ wqf.union(bottom, i); } // last row
        if (is_open(i-1) && in_to_col(n, in_to_row(n, i), i) != 1){ wqf.union(i, i-1); } // left
        if (is_open(i+1) && in_to_col(n, in_to_row(n, i), i) != n){ wqf.union(i, i+1); } // right
        if (in_to_row(n, i) != n && is_open(i+n)){ wqf.union(i, i+n); } // down
        if (in_to_row(n, i) != 1 && is_open(i-n)){ wqf.union(i, i-n); } // up

    }

    private boolean is_percolated(){ return wqf.connected(top, bottom); }

    private ArrayList<Integer> connected_top(int n){
        ArrayList<Integer> connect_top = new ArrayList<>();
        int count = 0;
        for (int i=1; i<(n*n+1); i++){
            if (wqf.find(i) == wqf.find(0)){ connect_top.add(i); count=0; }
            else { count++; }
            if (count >= n ){ break; }
        }
        return connect_top;
    }

    private ArrayList<Integer> connected_bottom(int n){
        ArrayList<Integer> connect_bottom = new ArrayList<>();
        int count = 0;
        for (int i=n*n; i > 0; i--){
            if (wqf.find(i) == wqf.find(n*n+1)){ connect_bottom.add(i); count=0; }
            else { count++; }
            if (count >= n){ break; }
        }
        return connect_bottom;
    }

    public static void main(String[] args) throws Exception {
        if(args.length != 0) {
            // read file from args[0] in Java 7 style
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

                // store data from file
                String data = br.readLine();
                int N = Integer.parseInt(data);
                int row;
                int col;

                // initialization of a Percolation data structure
                Percolation percolation = new Percolation(N);
                while ((data = br.readLine()) != null) {
                    row = Integer.parseInt(data.split(",")[0]);
                    col = Integer.parseInt(data.split(",")[1]);
                    percolation.open_grid(percolation.co_to_in(N, row, col));
                }

                // union every grid
                for(int i=1; i <= N*N; i++){
                    if(percolation.is_open(i)) {
                        percolation.connect(N, i);
                    }
                }

                // determine result
                int open_row = 0, open_col = 0, top_size, bottom_size;
                if (percolation.is_percolated()) { StdOut.print("0"); }
                else {
                    if (N == 1) {
                        open_row = 1;
                        open_col = 1;
                    }
                    else if (N == 2) {
                        ArrayList<Integer> top_group = percolation.connected_top(N);
                        top_size = top_group.size();
                        ArrayList<Integer> bottom_group = percolation.connected_bottom(N);
                        bottom_size = bottom_group.size();
                        if (top_size != 0) {
                            for (int i = 0; i <= 1; i++) {
                                if (percolation.is_open(i)) {
                                    open_row = percolation.in_to_row(N, i + 2);
                                    open_col = percolation.in_to_col(N, open_row, i + 2);
                                    break;
                                }
                            }
                        }
                        else if (bottom_size != 0) {
                            for (int i = 3; i <= 4; i++) {
                                if (percolation.is_open(i)) {
                                    open_row = percolation.in_to_row(N, i - 2);
                                    open_col = percolation.in_to_col(N, open_row, i - 2);
                                }
                            }
                        }
                    }
                    else {
                        int a, b;
                        ArrayList<Integer> top_group = percolation.connected_top(N);
                        top_size = top_group.size();
                        ArrayList<Integer> bottom_group = percolation.connected_bottom(N);
                        bottom_size = bottom_group.size();
                        if (top_group.size() != 0) {
                            a = top_group.get(top_size - 1); // last element
                            if (a > N * (N - 2)) {
                                open_row = percolation.in_to_row(N, a + N);
                                open_col = percolation.in_to_col(N, open_row, a + N);
                            }
                        }
                        if (bottom_group.size() != 0) {
                            b = bottom_group.get(bottom_size - 1); // last element
                            if (b < (2 * N) + 1) {
                                open_row = percolation.in_to_row(N, b - N);
                                open_col = percolation.in_to_col(N, open_row, b - N);
                            }
                        }
                        if (top_group.size() != 0 && bottom_group.size() != 0) {
                            outerloop:
                            for (int i = top_size - 1; i > -1; i--) {
                                for (int j = 0; j < bottom_size; j++) {
                                    a = top_group.get(i);
                                    b = bottom_group.get(j);
                                    int diff = a - b;
                                    if (diff == 2 * N || diff == (-2) * N || ((diff == 2 || diff == -2) && percolation.in_to_row(N, a) == percolation.in_to_row(N, b))) {
                                        open_row = percolation.in_to_row(N, (a + b) / 2);
                                        open_col = percolation.in_to_col(N, open_row, (a + b) / 2);
                                        break outerloop;
                                    }
                                }
                            }
                        }
                    }

                    if (open_row != 0 && open_col != 0) {
                        System.out.printf("%d,%d", open_row, open_col);
                    }
                    else {
                        StdOut.print("-1");
                    }
                }
            }
        }
    }
}