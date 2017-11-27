import java.io.FileReader;
import java.io.BufferedReader;

public class Search {
    private final static int VH_length = 10;
    private final static int Dia_length = 14;
    //private MinPQ<>;


    public static void main(String args[]) throws Exception{
        if (args.length != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                int total_row = Integer.parseInt(br.readLine().split(" ")[1]);
                int total_col = Integer.parseInt(br.readLine().split(" ")[1]);
                String start[] = br.readLine().split(" ")[1].split(",");
                int start_row = Integer.parseInt(start[0]);
                int start_col = Integer.parseInt(start[1]);
                String goal[] = br.readLine().split(" ")[1].split(",");
                int goal_row = Integer.parseInt(start[0]);
                int goal_col = Integer.parseInt(start[1]);

                int[][] field = new int[total_row][total_col];

                for (int i=0; i<total_row; i++) {
                    String data[] = br.readLine().split(" ");
                    for (int j=0; j<total_col; j++) {
                        if (data[j].equals("nn")) field[i][j] = -1;
                        else field[i][j] = Integer.parseInt(data[j]);
                    }
                }

            }
        }
    }
}