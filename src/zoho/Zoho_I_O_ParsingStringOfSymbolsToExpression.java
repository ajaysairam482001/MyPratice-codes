/*
 input: 6/4*2-1  (String) should solve it and give answer
  output: 1
*/

package zoho;

import java.util.Scanner;
import java.util.Stack;

public class Zoho_I_O_ParsingStringOfSymbolsToExpression {
    public static int Evaluate(String expression){
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();

        for(int i=0;i<expression.length();i++){
            char s = expression.charAt(i);

            if(s == ' ')
                continue;

            if(Character.isDigit(s)){
                int num =0;
                while(i<expression.length()&& Character.isDigit(expression.charAt(i))){
                    num = num*10+Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(num);
            }
            if(s=='+'||s=='-'||s=='*'||s=='/'){
                while(!operator.empty() && hasPriority(s,operator.peek())){
                    operands.push(applied_op(operator.pop(),operands.pop(),operands.pop()));
                }
                operator.push(s);
            }
        }
        while(!operator.empty()){
            operands.push(applied_op(operator.pop(),operands.pop(),operands.pop()));
        }
        return operands.pop();
    }

    public static boolean hasPriority(char op1,char op2){
        if((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))
            return false;
        else
            return true;
    }

    public static int applied_op(char op,int b,int a){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if(b==0){
                    throw new UnsupportedOperationException();
                }
                return a/b;
        }
        return 0;
    }
    public static String format(String str) {
        int j = (str.length())/ 2;
        j++;
        StringBuilder s = new StringBuilder();
        str = str.trim();
        for (int i = 0; j < str.length(); i++,j++) {
            s.append(str.charAt(i));
            s.append(str.charAt(j));
        }
        s.append(str.charAt(str.length()/2));
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        String str = "12345*+-+"; //this is the input order which is formatted to expression
        if((Character.isDigit(str.charAt(str.length()-1)))){
            System.out.println("Output: "+Evaluate(str));
        }
        else {
            System.out.println("Input: "+format(str));
            System.out.println("Output: " + Evaluate(format(str)));
        }
    }
}
