package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Deck för att sätta kortobjekten i en kortlek
public class Deck {
    //Arraylist för att förvara alla kortobjekt i en kortlek
    private final List<Card> cards = new ArrayList<>();
    //Index för att hålla reda på kort som redan använts
    private int index = 0;

    //Konstruktor av Deck-klassen (kortlek)
    public Deck() {
        //Variabler som sätter högsta tillåtna värde på färg (4 st) och värde (13) för resp kort
        //samt en for-loop som placerar resp kort i arraylistan
        int numberOfSuits = 4;
        for (int i = 0; i < numberOfSuits; i++) {
            int numberOfValues = 13;
            for (int j = 1; j < numberOfValues; j++) {
                cards.add(new Card(i, j));
            }
        }
    }

    //Tar nästa kort ur leken
    public Card getTopCard () {
        return cards.get(index++);
    }

    //Blandar leken så att den slumpar fram ett kort
    public void shuffle () {
        index = 0;
        Collections.shuffle(cards);
    }
}
