import java.io.FileReader;
import java.io.BufferedReader;

public class Percolation{

    private int top = 0;
    private int bottom;
    private WeightedQuickUnionUF wqf;

    public Percolation(int n){
        bottom = n*n + 1;
        wqf = new WeightedQuickUnionUF(n*n + 2);
    }

    public boolean is_percolated(){
        return wqf.connected(top, bottom);
    }

    public static void main(String[] args) throws Exception {

        // read file from args[0] in Java 7 style
        if(args.length != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

                // read a line
                String data = br.readLine();

                // store the first integer in variable N (size)
                int N = Integer.parseInt(data);
                while((data = br.readLine()) != null){
                    System.out.println(data);
                }
                //boolean[][] coordinates = new boolean[][]; // All elements are default to false.

                // initialization of a Percolation data structure
                Percolation percolation = new Percolation(N);
            
                /*  now you can write your own solution to hw1
                 *  you can follow the instruction described below:
                 *
                 *  1. read the rest content of the file
                 *  2. open the sites one by one
                 *  3. after opening a site, check whether it is already percolation; if yes, output 0
                 *  4. if the system does not percolates after opening all the listed sites, determine whether the system will percolate after opening one more site; if yes, output the cooridates of the site; if not, output -1
                 *
                 *
                 *  [note]
                 *  you can use every data structure in standard Java packages (Java 8 supported)
                 *  the packages in stdlib.jar and algs4.jar are also available for you to use
                 *
                 *  [hint]
                 *  you can refer UF.java or WeightedQuickUnionUF.java here  http://algs4.cs.princeton.edu/code/
                 */
            }
        }
    }
}
