package com.gdstruc.midterms;

import java.util.Scanner;
import java.util.Random;

public class Player {
    private String name;
    private int draw;
    private int discard;
    private int retrieve;

    public void generateValues(){
        this.draw =  generateRandomNumber();
        this.discard = generateRandomNumber();
        this.retrieve = generateRandomNumber();
    }
    public int generateRandomNumber (){
        Random random = new java.util.Random();
        return random.nextInt(5 - 1) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.gdstruc.midterms.Player player = (com.gdstruc.midterms.Player) o;
        return draw == player.draw && discard == player.discard && retrieve == player.retrieve && java.util.Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, draw, discard, retrieve);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", draw=" + draw +
                ", discard=" + discard +
                ", retrieve=" + retrieve +
                '}';
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getDiscard() {
        return discard;
    }

    public void setDiscard(int discard) {
        this.discard = discard;
    }

    public int getRetrieve() {
        return retrieve;
    }

    public void setRetrieve(int retrieve) {
        this.retrieve = retrieve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        name = scanner.nextLine();

        this.name = name;
    }
}
