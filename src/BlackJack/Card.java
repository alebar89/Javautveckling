package BlackJack;

//Klass som definierar objektet kort/card.
public class Card {
    //Variabler för att tilldela rätt int- och stringvärde till kortobjekten
    private int cardSuit = 0;
    private int cardValue = 0;
    private String cardSuitString = "";
    private String cardValueString = "";

    //Används inte i mitt program
    public void setCardValue() {
    }

    //För att klassen Deck ska kunna komma åt rätt värde för respektive kort
    public int getCardValue() {
        return cardValue;
    }

    //Konstruktor som tilldelar alla kortobjekt sina respektive värden
    //(Så att ruter blir ruter, ess har default-värdet 1, kung har 13, o s v
    public Card(int cardSuit, int cardValue) {
        if (cardSuit == 0) {
            this.cardSuitString = "Ruter";
        } else if (cardSuit == 1) {
            this.cardSuitString = "Klöver";
        } else if (cardSuit == 2) {
            this.cardSuitString = "Hjärter";
        } else {
            this.cardSuitString = "Spader";
        }

        this.cardValue = cardValue;

        if (cardValue == 1) {
            this.cardValueString = "ess";
        } else if (cardValue == 11) {
            this.cardValueString = "knekt";
        } else if (cardValue == 12) {
            this.cardValueString = "dam";
        } else if (cardValue == 13) {
            this.cardValueString = "kung";
        } else {
            this.cardValueString = Integer.toString(cardValue);
        }
    }

    //ToString för att få utskrift som sträng och
    //inte platsen där strängen ligger...
    public String toString() {
        return cardSuitString + " " + cardValueString;
    }
}
