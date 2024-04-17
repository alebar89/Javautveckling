package BMICalculator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Dialog-window for accepting first user input and storing the value in a variable
        String inputWeight = JOptionPane.showInputDialog("Ange din vikt: ");
        double userWeight = Double.parseDouble(inputWeight);

        //Dialog-window for accepting second user input and storing the value in a varibale
        String inputLength = JOptionPane.showInputDialog("Ange din längd: ");
        double userLength = Double.parseDouble(inputLength);

        //Calculating the BMI based on the values written by the user
        double yourBMI = userWeight / (userLength * userLength);

        /*A variable made to store the value of "viktklass"
        that will be presented for the user at the end of the program*/
        String weightClass = "";

        //Deciding the users weightclass based on the BMI
        if (yourBMI < 18.5) {
            weightClass = "Undervikt";
        } else if (yourBMI >= 18.5 && yourBMI <= 25) {
            weightClass = "Normalvikt";
        } else if (yourBMI > 25 && yourBMI <= 30) {
            weightClass = "Övervikt";
        } else if (yourBMI > 30 && yourBMI <= 35) {
            weightClass = "Fetma klass 1";
        } else if (yourBMI > 35 && yourBMI <= 40) {
            weightClass = "Fetma klass 2";
        } else
            weightClass = "Fetma klass 3";

        //Variables needed to get the right output at the end
        //Strings to show the results in a window for example
        String strUserWeight = String.valueOf(userWeight);
        String strUserLength = String.valueOf(userLength);
        int intYourBmi = (int) yourBMI;
        String strYourBmi = String.valueOf(intYourBmi);

        //Presenting the result in a window
        JOptionPane.showMessageDialog(null,
                new
                        //Making a table to be able to show the result with the tab-function
                        JTextArea("Vikt\t"+strUserWeight +"\n"+
                        "Längd\t"+strUserLength+"\n"+
                        "BMI\t"+strYourBmi+"\n"+
                        "Viktklass\t"+weightClass));
    }
}