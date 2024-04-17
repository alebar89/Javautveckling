package BlackJack;

import java.util.Objects;

//Klass för att starta spelet
public class Game {

    //runGame sätter igång själva spelet
    public static void runGame() {
        //Nytt spel och ny runda är true by default
        boolean playGame = true;
        boolean playRound = true;
        //Skapar ny kortlek och variabel för att ta inmatning från användare
        String userInput = "";
        Deck deck = new Deck();

        //Nästlad while-loop för att ha spelläge och börja om efter varje
        //avslutad runda
        while (playGame) {
            //Frågar om spelare vill spela, tar in imatning i scanner-klassen
            System.out.println("Nytt spel? Ja/Nej");
            userInput = Scan.scan().next();

            //If för att läsa in användarinmatning
            //Vid ja fortsätter spelet, vid nej avslutas det
            //Ej case sensetive
            if (Objects.equals(userInput.toLowerCase(), "ja")) {
                deck.shuffle();
                playRound = true;
            } else if (Objects.equals(userInput.toLowerCase(), "nej")) {
                playGame = false;
                playRound = false;
            } else {
                //Hanterar felaktig inmatning
                //Endast ja eller nej tillåten inmatning
                System.out.println("Felaktig inmatning");
            }

            //Variabel för att hålla reda på användarens poäng
            int totalScore = 0;

            //Sätter igång ny spelrunda
            while (playRound) {
                //Frågar om användaren vill ha ett nytt kort
                //Läser in inmatning
                System.out.println("Dra ett kort? Ja/Nej");
                userInput = Scan.scan().next();

                //If-sats för att presentera vad användaren får för kort och sammanställa
                //poängen och presentera det på skärmen
                if (Objects.equals(userInput.toLowerCase(), "ja")) {
                    Card nextCard = deck.getTopCard();
                    System.out.println("Du drog " + nextCard);
                    //Esset har värde 1 by default, men får värde 14 om
                    //den totala poängen + 14 är mindre eller lika med 21
                    if (nextCard.getCardValue() == 1 && totalScore + 14 <= 21) {
                        totalScore += 14;
                    } else {
                        //...annars får esset sitt default-värde (1)
                        totalScore += nextCard.getCardValue();
                    }
                    //Skriver ut poängen på skärmen
                    System.out.println("Din poäng: " + totalScore);
                    //Kollar mot denna om poängen 21 eller mer uppnåtts och ger
                    //olika utfall, avbryter rundan om ett villkor är uppfyllt
                    if (totalScore == 21) {
                        System.out.println("Din poäng: " + totalScore);
                        System.out.println("Grattis du vann!\n");
                        playRound = false;
                    } else if (totalScore > 21) {
                        System.out.println("Din poäng: " + totalScore);
                        System.out.println("Tyvärr! Du förlorade :(\n");
                        playRound = false;
                    }
                    //Om användaren ej vill fortsätta avbryts rundan
                    //presenterar totalpoängen
                } else if (Objects.equals(userInput.toLowerCase(), "nej")) {
                    System.out.println("Spelet avslutat");
                    System.out.println("Din poäng blev: " + totalScore + "\n");
                    playRound = false;
                } else {
                    //Hanterar felaktig inmatning
                    System.out.println("Felaktig inmatning");
                }
            }
        }
    }
}
