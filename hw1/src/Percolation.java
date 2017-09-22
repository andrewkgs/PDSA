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

    private int convert(int n, int x, int y){
        return n*(x-1)+y;
    }

    private void open_grid(int i){
        grid_state[i] = true;
    }

    private boolean is_open(int i){ return grid_state[i]; }

    private void connect(int n, int x, int y, int i){
        if(x == 1){ wqf.union(top, i); }
        else if(x == n){ wqf.union(bottom, i); }
        if(is_open(convert(n, x, y-1)) && y != 1){ wqf.union(i, i-1); }
        if(is_open(convert(n, x, y+1)) && y != n){ wqf.union(i, i+1); }
        if(x != n && is_open(convert(n, x+1, y))){ wqf.union(i, i+n); }
    }
    private boolean is_percolated(){
        return wqf.connected(top, bottom);
    }

    private ArrayList<Integer> connected_top(int n){
        ArrayList<Integer> connect_top = new ArrayList<>();
        for (int i=1; i<(n*n+1); i++){
            if (wqf.find(i) == wqf.find(0)){ connect_top.add(i); }
        }
        return connect_top;
    }

    private ArrayList<Integer> connected_bottom(int n){
        ArrayList<Integer> connect_bottom = new ArrayList<>();
        for (int i=n*n; i > 0; i--){
            if (wqf.find(i) == wqf.find(n*n+1)){ connect_bottom.add(i); }
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

                ArrayList<Integer> row = new ArrayList<Integer>();
                ArrayList<Integer> col = new ArrayList<Integer>();
                while((data = br.readLine()) != null){
                    row.add(Integer.parseInt(data.split(",")[0]));
                    col.add(Integer.parseInt(data.split(",")[1]));
                }
                br.close();

                // initialization of a Percolation data structure
                Percolation percolation = new Percolation(N);

                int index;
                for (int i=0; i<row.size(); i++){
                    index = percolation.convert(N, row.get(i), col.get(i));
                    percolation.open_grid(index);
                }
                for (int i=0; i<row.size(); i++){
                    index = percolation.convert(N, row.get(i), col.get(i));
                    percolation.connect(N, row.get(i), col.get(i), index);
                }

                if (percolation.is_percolated()){ System.out.printf("0"); }
                else{
                    int open_row=0, open_col=0;
                    outerloop:
                    for (int i=percolation.connected_top(N).size()-1; i>=0;  i--) {
                        for (int j = 0; j < percolation.connected_bottom(N).size(); j++) {
                            int a = percolation.connected_top(N).get(i);
                            int b = percolation.connected_bottom(N).get(j);
                            int diff = a - b;
                            int avg = (a + b) / 2;
                            if (diff == 2*N || diff == (-2)*N || ((diff == 2 || diff == -2) && (a-1)/N == (b-1)/N)){
                                open_row = ((avg-1) / N) + 1;
                                open_col = avg - ((open_row-1) * N);
                                break outerloop;
                            }
                        }
                    }
                    if (open_row != 0 && open_col != 0){ System.out.printf("%d,%d", open_row, open_col); }
                    else { System.out.printf("-1"); }
                }
            }
        }
    }
}
