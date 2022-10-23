package com.gdstruc.midterms;

import java.util.Random;

public class Card {

    private String cardName;
    private String attribute;

    public Card() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute() {
        Random random = new Random();
        int cardRankPicker = random.nextInt(12); // 13 types of cards: 1-10, Jack, Queen, and King -1 since count starts 0.
        int cardTypePicker = random.nextInt(3); // 4 shapes -1 since count starts 0.

        String[] cardRank = new String[]{
                "Ace of ", "2nd of ", "3rd of ", "4th of ", "5th of ", "6th of ", "7th of ", "8th of ",
                "9th of ", "10th of ", "Jack of ", "Queen of ", "King of "
        };

        String[] cardType = new String[]{
                "Hearts", "Diamonds", "Spades", "Clubs"
        };

        attribute = cardRank[cardRankPicker] + cardType[cardTypePicker];

        this.attribute = attribute;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName() {
        Random random = new Random();
        int namePicker = random.nextInt( 59); // 60 names. -1 since count starts 0.

        String[] names = new String[]{
                "Huffe", "Gerarda", "Harrelsone", "Edith", "Haleye",
                "Primrose", "Aiken", "Sigeberht", "Arkwrighte", "Melba",
                "Combose", "Haige", "Edvin", "Brooke", "Leofric",
                "Haywarde", "Mildred", "Fenne", "Whitakere", "Appletone",
                "Harper", "Lili", "Greye", "Rovena", "Algere",
                "Hailie", "Hortone", "Haywoode", "Alveye", "Fairley",
                "Royce", "Hoggarde", "Annice", "Egbert", "Irvine",
                "Eoforhild", "Waynee", "Baine", "Fultone", "Melinda",
                "Eldrede", "Æðelric", "Beorhtric", "Waltone", "Averil",
                "Sunniva", "Headleye", "Varnhame", "Heartha", "Fenne",
                "Garry", "Edda", "Greene", "Marlee", "Hillame",
                "Mildgyð", "Warricke", "Langley", "Blythe", "Wallis"}; // 60 Names in total

        cardName = names[namePicker];

        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return cardName + " the " + attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.gdstruc.midterms.Card card = (com.gdstruc.midterms.Card) o;
        return java.util.Objects.equals(cardName, card.cardName) && java.util.Objects.equals(attribute, card.attribute);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(cardName, attribute);
    }
}
