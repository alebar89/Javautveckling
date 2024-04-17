package Dice;

//Importing necessary libraries
import java.io.*;
import java.util.*;

//Declaration of class Dice
public class Dice {
    //Method for creating the file with 1000 randomised numbers between 1-6
    public static void createFile() {

        //Variables for randomisation and creation of the file
        Random getRandomNumbers  = new Random();
        File resultOfRandomNumbers;

        //Try-catch for error-handling when creating the file
        try {
            //Creating the file
            resultOfRandomNumbers = new File("result.txt");
            if (resultOfRandomNumbers.createNewFile()) {
                System.out.println("File created: " + resultOfRandomNumbers.getName());
            } else {
                //In case the file already exists (it is later overwritten)
                System.out.println("File " + resultOfRandomNumbers.getName() + " already exists");
            }
        } catch (IOException e) {
            //In case the file couldn't be created
            System.out.println("An error occurred");
        }

        //A new try-catch statement when writing to the file
        try {
            //Always set to false by default and therefore overwriting the content
            //in the text document. If set to true, then the new content will be
            //added without removing the old content.
            FileWriter myWriter = new FileWriter("result.txt");
            //Giving us 1000 numbers
            for (int i = 0; i < 1000; i++) {
                //+ 1 to not start from 0 which gives us numbers between 1-6 (not 0-5)
                int j = getRandomNumbers.nextInt(6) + 1;
                //Saving the numbers generated to a string
                String s = String.valueOf(j);
                //Writing the string to the text file and adding a space between each number
                myWriter.write(s);
                myWriter.write(" ");
            }
            //Closing for not getting an empty file
            myWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            //If somehow content couldn't be written to the file
            System.out.println("An error occurred");
        }

        //Void no return-statement needed
    }

    //Method for creating the array storing the result of each randomised value
    public static int[] createArray() throws Exception {

        //Scanner object for scanning the content in the file
        Scanner scan = new Scanner(new File("result.txt"));

        //Creating the array
        int[] storingRandomNumbers = new int[1000];

        //Writing one number for every element in the array as integers
        for (int i = 0; i < storingRandomNumbers.length; i++) {
            storingRandomNumbers[i] = scan.nextInt();
        }
        //Return statement
        return storingRandomNumbers;
    }

    //Method for creating the array counting each number from the file
    public static void analyseArray(int [] createArray) throws Exception {

        //Variables used for counting every type of number in the "big" array
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;

        //Creating new array for storing the result
        int[] valueOfAnalysis = new int[6];
        //Looping through the big array to count every number (1-6) that appears
        //Storing the value in one of the variables depending on the number
        for (int i : createArray) {
            if (i == 1) {
                count1++;
            } else if (i == 2) {
                count2++;
            } else if (i == 3) {
                count3++;
            } else if (i == 4) {
                count4++;
            } else if (i == 5) {
                count5++;
            } else if (i == 6) {
                count6++;
            }
        }

        //Saving the result in the array elements
        valueOfAnalysis[0] = count1;
        valueOfAnalysis[1] = count2;
        valueOfAnalysis[2] = count3;
        valueOfAnalysis[3] = count4;
        valueOfAnalysis[4] = count5;
        valueOfAnalysis[5] = count6;

        //Creating the file for displaying the result
        //Try-catch statement for error-handling
        try {
            File resultOfAnalysis = new File("analyse.txt");
            if (resultOfAnalysis.createNewFile()) {
                System.out.println("File created: " + resultOfAnalysis.getName());
            } else {
                System.out.println("File " + resultOfAnalysis.getName() + " already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
        }

        //A new file writer object
        FileWriter myWriter = new FileWriter("analyse.txt");

        //Looping through the document to get the result from the new analyse-file
        //and writing them to the terminal and text-file
        for (int i = 0; i < valueOfAnalysis.length; i++) {
            System.out.println(i + 1 + ": " + valueOfAnalysis[i]);
            myWriter.write(i + 1 + ": " + valueOfAnalysis[i]);
            myWriter.write("\r\n");
        }
        //Closing not to get empty file
        myWriter.close();
        //Void return-statement not needed
    }
}