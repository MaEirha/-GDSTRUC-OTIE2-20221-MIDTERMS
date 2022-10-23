package com.gdstruc.midterms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        int cardsLeft = 30;
        int onHand = 0;
        int discardedCards = 0;

        CardStack stack = new CardStack(30);
        DiscardedCardStack discardStack = new DiscardedCardStack(30);
        Player player = new Player();
        player.setName("");

        do {
            choice = choices(player, cardsLeft, onHand, discardedCards);
            switch (choice) {
                case 1: // DRAW
                    System.out.println(" ");
                    System.out.println("=================================================================");
                    System.out.println("You have drawn " + player.getDraw() + " card/s.");
                    cardsLeft -= player.getDraw();
                    onHand += player.getDraw();
                    for (int i = 0; i < player.getDraw(); i++) {
                        cardSetUp(stack);
                    }
                    break;

                case 2: // DISCARD
                    System.out.println(" ");
                    System.out.println("=================================================================");
                    System.out.println("You have discarded " + player.getDiscard() + " card/s.");
                    discardedCards += player.getDiscard();
                    onHand -= player.getDiscard();
                    for (int i = 0; i < player.getDiscard(); i++) {
                        discardStack.push(stack.pop());
                    }
                    break;

                case 3: // RETRIEVE
                    System.out.println(" ");
                    System.out.println("=================================================================");
                    System.out.println("You have retrieved " + player.getRetrieve() + " card/s.");
                    discardedCards -= player.getRetrieve();
                    onHand += player.getRetrieve();
                    for (int i = 0; i < player.getRetrieve(); i++) {
                        stack.push(discardStack.pop());
                    }
                    break;
            }
            
            stats(player, cardsLeft, onHand, stack, discardedCards, discardStack);
        } while ((cardsLeft > 0) && (onHand > 0));
        // exit when there are no more cards left on both deck and player hand

    }

    public static void cardSetUp(CardStack stack){
        Card card = new Card();

        card.setCardName();
        card.setAttribute();

        System.out.println("Your card's name is: " + card.getCardName() + " the " + card.getAttribute());

        stack.push(card);
    }

    public static int choices(Player player, int cardsLeft, int onHand, int discardedCards) {
        int choice;

        player.generateValues();

        if (cardsLeft < player.getDraw()){
            player.setDraw(cardsLeft);
            // Prevent drawing past the 30 cards limit
        }

        if (onHand < player.getDiscard()){
            player.setDiscard(onHand);
            // Prevent discarding past the on hand limit
        }

        if (discardedCards < player.getRetrieve()){
            player.setRetrieve(discardedCards);
            // Prevent retrieving past the discarded cards limit
        }

        do {
            System.out.println(" ");
            System.out.println("=================================================================");
            System.out.println("What would you like to do?");
            System.out.println("CHOICES: ");
            System.out.println("    (1) DRAW " + player.getDraw() + " card/s from your deck.");
            System.out.println("    (2) DISCARD " + player.getDiscard() + " card/s from your deck.");
            System.out.println("    (3) RETRIEVE " + player.getRetrieve() + " card/s from the discarded pile.");
            System.out.println("[ Please choose within the range of choices unless you want to loop forever? Not that I mind. :) ]");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } while (choice >= 3 || choice <= 0);
        return choice;
    }

    public static void stats(Player player, int cardsLeft, int onHand, CardStack stack, int discardedCards, DiscardedCardStack discardStack){
        System.out.println(" ");
        System.out.println("=================================================================");
        System.out.println("STATS OF " + player.getName().toUpperCase() + ":");
        System.out.println("    Player Cards On-Hand: " + onHand);
        System.out.println("    Cards Left On-Deck: " + cardsLeft);
        System.out.println("    Discarded Cards: " + discardedCards);
        System.out.println(" ");
        System.out.println("=================================================================");
        System.out.println("LIST OF " + player.getName().toUpperCase() + "'S CARDS:");
        stack.printStack();
        System.out.println(" ");
        System.out.println("=================================================================");
        System.out.println("LIST OF " + player.getName().toUpperCase() + "'S DISCARDED CARDS:");
        discardStack.printStack();
    }

}
