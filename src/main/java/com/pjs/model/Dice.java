package com.pjs.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int count = 0;
        int diceTotal = 0;
        while (count < diceCount) {
            int rollDice = ThreadLocalRandom.current().nextInt(1, 6);
            diceTotal += rollDice;
            count++;
        }
        return diceTotal;
    }
}
