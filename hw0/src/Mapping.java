import java.io.FileReader;
import java.io.BufferedReader;

public class Mapping {

    public static void main(String[] args) throws Exception {

        if(args.length != 0) {
            // read file from args[0] in Java 7 style
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

                // read a line
                String data = br.readLine();

                // store the first integer in variable readCount (number of reads)
                int readCount = Integer.parseInt(data);

                // initialization of a String array
                String[] readsArray = new String[readCount];
                String reference = new String();

                for (int i = 0; i < readCount; i++) {
                    readsArray[i] = br.readLine();
                }
                reference = br.readLine();

                int readLength;
                int[] count = new int[readCount];

                for (int j = 0; j < readCount; j++) {
                    readLength = readsArray[j].length();
                    for (int k = 0; k < reference.length()-readLength+1; k++) {
                        if (readsArray[j].equals(reference.substring(k, k+readLength))) {
                            count[j]++;
                        }
                    }
                }
                br.close();

                int count_1 = 0, count_2 = 0;
                for (int m = 0; m < readCount; m++) {
                    if (count[m] >= 1){
                        count_1++;
                    }
                    if (count[m] >= 2){
                        count_2++;
                    }
                }
                System.out.printf("%d\n%d\n", count_1, count_2);
            }
        }
    }
}