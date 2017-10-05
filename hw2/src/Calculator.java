import java.util.Stack;

public class Calculator {

    private Double calculate(String s, double a, double b){

        switch (s){
            case "+": return b + a;
            case "-": return b - a;
            case "*": return b * a;
            case "/": return b / a;
            default: StdOut.println(s); return -1000.0; // This should not happen.
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
                    case "(":
                        op.push(s);
                        break;
                    case "*":
                    case "/":
                        op.push(s);
                        priority = true;
                        break;
                    case ")":
                        if (!op.peek().equals("(")){
                            va.push(calculate(op.pop(), va.pop(), va.pop()));
                        }
                        break;
                    default:{
                        va.push(Double.parseDouble(s));
                        break;
                    }
                }
            }

            else{
                priority = false;
                switch (s){
                    case "(":{
                        op.push(s);
                        break;
                    }
                    // default in here will only be values.
                    default:{
                        va.push(calculate(op.pop(), Double.parseDouble(s), va.pop()));
                        break;
                    }
                }
            }
        }

        String front_sign, back_sign;
        Double front_value, back_value;
        while(va.size() > 1){
            //if (op.peek().equals("(")){ op.pop(); }

            back_sign = op.pop();
            back_value = va.pop();
            if (va.size() == 1){ front_sign = "+"; }
            else{ front_sign = op.pop(); }
            front_value = va.pop();

            if (back_sign.equals("-")){ back_value *= -1; }
            if (front_sign.equals("-")){ front_value *= -1; }
            va.push(back_value + front_value);
            op.push("+");
        }

        return va.pop();
    }
}
