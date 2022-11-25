package calculator;
// a primative calculator 
// a code by Lujain Alsasa

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your simple mathematical equation that contains multiplication, addition, division, and brackets");
        String s = in.nextLine(), str = "";
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
             //    If it is an operator, then
                    //i) If stack is empty, push operator on stack.
                    //ii) If the top of stack is opening parenthesis, push operator on stack
                    //iii) If it has higher priority than the top of stack, push operator on stack.
                    //iv) Else pop the operator from the stack and output it, repeat step 4 
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                str += " ";
                boolean f = true;
                while (f) {
                    if (temp.isEmpty()) {
                        temp.push(s.charAt(i));
                        f = false;
                    } else if (temp.top().equals('(')) {
                        temp.push(s.charAt(i));
                        f = false;
                    } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                        if (temp.top().equals('+') || temp.top().equals('-')) {
                            temp.push(s.charAt(i));
                            f = false;
                        } else {
                            str += temp.top();
                            temp.pop();

                        }
                    } else {
                        str += temp.top();
                        temp.pop();

                    }
                }
            }//If it is opening parenthesis, push it on stack 
            else if (s.charAt(i) == '(') {
                str += " ";
                temp.push(s.charAt(i));
            }//If it is a closing parenthesis, pop operators from stack and output them until an opening parenthesis is encountered.
            //pop and discard the opening parenthesis.
            else if (s.charAt(i) == ')') {
               str += " ";
                while (!temp.top().equals('(')) {
                    str += temp.top();
                    temp.pop();
                }
                temp.pop();

            }//If it is operand, output it. 
            else {
                str += s.charAt(i);
            }
        }
        str += " ";
        //If there is no more input, pop the remaining operators to output.
        while (!temp.isEmpty()) {
            str += temp.top();
            temp.pop();
        }
       // System.out.print("the Postfix is: ");
       // System.out.println(str);
        boolean f = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                System.out.println("invalid input");
                f = false;
            }
        }

//        Initialise an empty stack
//While token remain in the input stream
//Read next token
//If token is a number, push it into the stack
//Else, if token is an operator, pop top two tokens off the stack,apply the operator, and push the answer back into the stack
//Pop the answer off the stack.
//ex:(5+9)*(7+(7.6/8*66)/7)+7 ans:230.4
        Stack<Double> x = new Stack<>();
        if (f == true) {String tempStr ="";
       
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/') {
                    if (str.charAt(i) == '*') {
                        double num1 = x.top();
                        x.pop();
                        double num2 = x.top();
                        x.pop();
                        double y=num2 * num1;
                        //System.out.println(y);
                        x.push(y);

                    } else if (str.charAt(i) == '/') {
                        double num1 = x.top() ;
                        x.pop();
                        double num2 = x.top();
                        x.pop();
                        double y=num2 / num1;
                        //System.out.println(y);
                        x.push(y);

                    } else if (str.charAt(i) == '+') {
                        double num1 = x.top();
                        x.pop();
                        double num2 = x.top();
                        x.pop();
                        double y=num2 + num1;
                       // System.out.println(y);
                        x.push(y);

                    } else {
                        double num1 = x.top();
                        x.pop();
                        double num2 = x.top();
                        x.pop();
                        double y=num2 - num1;
                       // System.out.println(y);
                        x.push(y);

                    }
                }
                else if(str.charAt(i)==' '){
                
            } 
                else {double num=0;
                   while(str.charAt(i)!=' '){
                   tempStr += str.charAt(i);  
                   i++;
                    }
                     
                        // System.out.println(tempStr);
                         num=Double.parseDouble(tempStr);
                       // System.out.println(num);
                        x.push(num);
                        tempStr ="";
                     
                                
                }

            }
            System.out.print("the answer is: ");
            System.out.println(x.top());

        }
    }

}
