package Calculator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Window to accept input from the user
        String userInput = JOptionPane.showInputDialog("MINIRÄKNARE" +
                " (PLUS, MINUS, GÅNGER el DELAT MED)\n" +
                "Skriv ett giltigt matematiskt uttryck\n" +
                "Någon av följande operatorer måste finnas med: +-*/");
        //Removing all blank spaces so that the program just reads the numbers
        userInput = userInput.replace(" ", "");

        //Variables
        int numberOfCharacters = userInput.length();
        char operator = ' ';
        String firstPartOfExpression = null;
        String secondPartOfExpression = null;
        double firstOperand = 0;
        double secondOperand = 0;
        double resultOfCalculation = 0;
        int positionOfOperator = 0;

        /*IF-statement to check if the input-string is empty;
        if it is empty, the program will give an error-message*/
        if (numberOfCharacters > 0) {

            /*For-loop to identify the operator;
            if it doesn't find one, the program will give an error-message.
            It only accepts one of the following four valid operators: + - * /
            Breaks one finding one to make sure the whole expression is valid
            */
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) == '+') {
                    positionOfOperator = i;
                    operator = '+';
                    break;
                    /*For the program to accept negative numbers we need to allow
                    minus at the beginning without making the program identify it
                    as an operator, therefore I put in the "contains"-method to see if the string
                    contains a minus-symbol and thereafter continue the search from
                    the second character, to skip the first one if it is a minus*/
                } else if (userInput.contains("-")) {
                    if (userInput.charAt(i+1) == '-') {
                        positionOfOperator = i+1;
                        operator = '-';
                        break;
                    }
                } else if (userInput.charAt(i) == '*') {
                    positionOfOperator = i;
                    operator = '*';
                    break;
                } else if (userInput.charAt(i) == '/') {
                    positionOfOperator = i;
                    operator = '/';
                    break;
                }

            }

            /*IF-statement for giving an error-message
            if a valid operator is missing in the user input-string*/
            if (operator == ' ') {
                System.out.println("Det saknas en giltig operator");

                /*If a valid operator is found this piece of code
            searches through the rest of the string to find
            what's to the left and to the right of the operator
            and saves them in two separate strings*/
            } else {
                for (int i = 0; i < userInput.length(); i++) {
                    firstPartOfExpression = userInput.substring(0, positionOfOperator);
                    secondPartOfExpression = userInput.substring(positionOfOperator + 1, numberOfCharacters);
                }

                /*Here the program tries the stings to the right and left
                of the operator to see if they are valid operands,
                by converting them into doubles. This way we will exclude all
                the invalid operands (for example 2.2.3 or more than one
                operator) but still accept negative numbers.*/
                try {
                    firstOperand = Double.parseDouble(firstPartOfExpression);
                    secondOperand = Double.parseDouble(secondPartOfExpression);

                    /*IF-statement for knowing what type of calculation to be made
                    depending on what operator the program found*/
                    if (operator == '+') {
                        resultOfCalculation = Addition(firstOperand, secondOperand);
                    } else if (operator == '-') {
                        resultOfCalculation = Subtraction(firstOperand, secondOperand);
                    } else if (operator == '*') {
                        resultOfCalculation = Multiplication(firstOperand, secondOperand);
                    } else if (operator == '/') {
                        /*IF-statement for giving an error when user
                         tries to divide by zero*/
                        if (secondOperand == 0) {
                            System.out.println("Du kan inte dividera med noll");
                        }
                        resultOfCalculation = Division(firstOperand, secondOperand);
                    }

                    /*Presenting the result of the calculation
                         in case no error was found*/
                    System.out.println(resultOfCalculation);

                    /*Giving an error-message if an invalid operand
                     is found*/
                } catch (NumberFormatException e) {
                    System.out.println("Felaktig inmatning");
                }
            }

            //Error-message if there is no input
        } else {
            System.out.println("Du har inte skrivit någonting");
        }

    }

    //Methods for performing the calculation
    public static double Addition(double a, double b) {
        return a + b;
    }

    public static double Subtraction(double a, double b) {
        return a - b;
    }

    public static double Multiplication(double a, double b) {
        return a * b;
    }

    public static double Division(double a, double b) {
        return a / b;
    }
}