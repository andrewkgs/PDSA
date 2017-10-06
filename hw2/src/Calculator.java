import java.util.Stack;

public class Calculator {

    public Double ans (String e) {

        Stack<Double> va = new Stack<>();
        Stack<String> op = new Stack<>();

        String[] content = e.split(" ");
        for (String s: content){
            if (va.empty() && op.empty()){
                op.push("+");
            }
            if (s.equals("+") || s.equals("-")){
                op.push(s);
            }
            else if (s.equals("*") || s.equals("/")){
                op.push(s);
            }
            else if (s.equals("(")){
                op.push(s);
                op.push("+");
            }
            else if (s.equals(")")){
                while (!op.peek().equals("(")) {
                    double b = va.pop();
                    String d = op.pop();
                    if (d.equals("-")){
                        b *= -1;
                    }
                    double a;
                    if (!va.empty()) {
                        a = va.pop();
                    }
                    else{
                        a = 0.0; // when va is empty.
                    }
                    String c = op.pop();
                    if (c.equals("(")){ // "(" has been pop out.
                        va.push(a);
                        va.push(b);
                        if (op.size() == 1){
                            op.push("+");
                        }
                        break;
                    }
                    else if (c.equals("-")){
                        a *= -1;
                    }
                    va.push(a+b);
                    op.push("+");
                }
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
            // else: s is a value
            else {
                va.push(Double.parseDouble(s));
                if (op.peek().equals("*")){
                    op.pop();
                    va.push(va.pop() * va.pop());
                }
                else if (op.peek().equals("/")){
                    op.pop();
                    va.push(1 / va.pop() * va.pop());
                }
            }
        }


        while (!va.empty()){ StdOut.println(va.pop()); }
        while (!op.empty()){ StdOut.println(op.pop()); }

        return 10.0;
    }
}
