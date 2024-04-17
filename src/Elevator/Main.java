package Elevator;

//Importing necessary libraries
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating two new objects of the elevator-class using the constructor
        //from elevator
        Elevator elevator01 = new Elevator(3);
        Elevator elevator02 = new Elevator(5);

        //Message to the user for understanding the program
        System.out.println("Välkommen in i hissen. Hissen kan ta sig från\n" +
                "källarvåningen på plan -2 till sista planet på våning 10.\n" +
                "Mata in en siffra för att välja våning.\n" +
                "Skriv /where om du vill veta vilket\n" +
                "våningsplan hissen befinner sig på just nu.\n" +
                "Tryck enter om du vill avsluta programmet.\n");
        //Printing out where the elevator stands from the beginning, taking values
        //from the constructor objects
        elevator01.where();

        //Looping as long as the use wants
        while (true) {
            //Creating a scanner object
            Scanner scan = new Scanner(System.in);
            //Asking the user where to go
            System.out.println("Vilken våning vill du åka till?");
            //Reading the user input using the scanner class and
            //saving it in a variable
            String userInput = scan.nextLine();

            //Checking if the input is empty
            //If it is the program is terminated
            if (userInput.isEmpty()) {
                break;
            }

            //Checking if the user writes /where to check the present level
            //If yes then a message telling the user where the elevator is, is displayed
            //If no, then the program continues
            if (userInput.equals("/where")) {
                elevator01.where();
            } else {
                //Trying if the input is an integer, if not the program displays an
                //error-message telling the user that the input is wrong
                try {
                    int inputToInt = Integer.parseInt(userInput);
                    elevator01.goTo(inputToInt);
                } catch (NumberFormatException e) {
                    System.out.println("Du måste mata in en siffra!");
                }
            }
        }
    }
}