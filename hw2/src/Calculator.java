import java.util.Stack;

public class Calculator {

    private Double calculate(String s, double a, double b){
        switch (s){
            case "+": { return b + a; }
            case "-": { return b - a; }
            case "*": { return b * a; }
            case "/": { return b / a; }
            default: { return 0.0; } // This should not happen.
        }
    }

    public Double ans (String e) {

        Stack<Double> va = new Stack<>();
        Stack<String> op = new Stack<>();
        boolean priority = false; // if the previous operator is "*" or "/", then priority == true.

        String[] content = e.split(" ");
        for (String s: content){
            if (!priority) {
                switch (s){
                    case "+":
                    case "-":
                    case "(": { op.push(s); }
                    case "*":
                    case "/": {
                        op.push(s);
                        priority = true;
                    }
                    case ")": {
                        while (!op.pop().equals("(")){
                            va.push(calculate(op.pop(), va.pop(), va.pop()));
                        }
                    }
                    default:{
                        va.push(Double.parseDouble(s));
                    }
                }
            }

            else{
                priority = false;
                switch (s){
                    case "(":{ op.push(s); }
                    // default in here will only be values.
                    default:{
                        va.push(calculate(op.pop(), Double.parseDouble(s), va.pop()));
                    }
                }
            }
        }

        while(op.pop() != null){
            va.push(calculate(op.pop(), va.pop(), va.pop()));
        }

        return va.pop();
    }
}
