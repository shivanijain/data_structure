package com.stack;

/**
 * Created by Jainish on 05-03-2017.
 */
public class InfixToPostFix extends Stack {
    public static void main(String[] args) {
        String expression = "231*+9-";
        Stack s = new Stack();
        InfixToPostFix fix = new InfixToPostFix();
        for( int index=0;index<expression.length();index++) {
            char ch = expression.charAt(index);
            if( true == fix.isOperator(ch)) {
                int number1= s.pop();
                int number2 = s.pop();
                System.out.println("n3umber"+number1+"-->"+number2);
                s.push(fix.performOperator(number1,number2,ch));
            } else {
                System.out.println("num"+ch);
                s.push(Character.getNumericValue(ch));
            }
        }
            System.out.println("Result"+s.pop());

    }

    public boolean isOperator( char ch ) {
        switch (ch){
            case '*':
            case '+':
            case '-':
            case '/':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    public int performOperator( int a, int b, char operator) {
        switch (operator){
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }
}


