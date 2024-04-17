package Dice;

//Importing necessary libraries
import java.io.*;

//New class FileAnalyser
public class FileAnalyzer {

    //Method for counting the characters in a text document
    public static void CountingCharacters() throws IOException {

        //The file to be read
        File file = new File(
                "result.txt");

        //Reading the text file
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        //Variables needed for the calculation
        String s;
        int i = 0;

        //Reading every line until it doesn't find anymore characters
        while ((s = br.readLine()) != null) {
            //Adding each line together and saving them to the variable above
            i = i + s.length();
        }
        //Writing the result in the terminal
        System.out.println(i);
    }
}