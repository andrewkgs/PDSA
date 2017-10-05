public class Main {
    public static void main(String[] args) {
        Calculator cct = new Calculator();
        Double d = cct.ans("1 + 6 / 2 * ( 1 + 2 ) - 4 * ( 5 - 3 )");
        StdOut.println(d);
    }
}