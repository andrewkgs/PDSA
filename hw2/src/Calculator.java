import java.util.Stack;

public class Calculator {

    public Double ans (String e) {

        Stack<Double> va = new Stack<>();
        Stack<String> op = new Stack<>();
        boolean first_check = true;

        String[] content = e.split(" ");
        for (String s: content){
            if (va.empty() && op.empty() && !s.equals("(")){
                if (!s.equals("(")){
                    op.push("+");
                }
                else {
                    op.push(s); // s is "("
                    op.push("+");
                    first_check = false;
                }
            }
            if (s.equals("+") || s.equals("-")){
                op.push(s);
            }
            else if (s.equals("*") || s.equals("/")){
                op.push(s);
            }
            else if (s.equals("(") && !first_check){
                op.push(s);
                op.push("+");
            }
            else if (s.equals(")")){
                while (!op.peek().equals("(")) {
                    double b = va.pop();
                    if (op.pop().equals("-")){
                        b *= -1;
                    }
                    double a = va.pop();
                    if (op.pop().equals("-")){
                        a *= -1;
                    }
                    va.push(a+b);
                }
                op.pop(); // pop out "("
                if (op.peek().equals("*")){
                    op.pop();
                    double b = va.pop();
                    double a = va.pop();
                    va.push(a * b);
                }
                else if (op.peek().equals("/")){
                    op.pop();
                    double b = va.pop();
                    double a = va.pop();
                    va.push(a / b);
                }
            }
            // s is a value
            else {
                va.push(Double.parseDouble(s));
                if (op.peek().equals("*")){
                    va.push(va.pop() * va.pop());
                }
                else if (op.peek().equals("/")){
                    va.push(1 / va.pop() * va.pop());
                }
            }
        }


        while (!va.empty()){ StdOut.println(va.pop()); }
        while (!op.empty()){ StdOut.println(op.pop()); }

        return 10.0;
    }
}
