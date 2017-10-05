public class Main {
    public static void main(String[] args) {
        Calculator cct = new Calculator();
        Double d = cct.ans("1 + 2 * ( 3 - 4 * 5 ) ");
        StdOut.println(d);
    }
}