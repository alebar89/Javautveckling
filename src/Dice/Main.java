package Dice;

public class Main {
    public static void main(String[] args) throws Exception {

        //Calling the methods from the Dice-class
        Dice.createFile();
        Dice.createArray();
        Dice.analyseArray(Dice.createArray());
        FileAnalyzer.CountingCharacters();

    }
}