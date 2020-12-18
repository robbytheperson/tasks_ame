package com.example.myapplication;

import java.util.Random;

public class Randomizer {

    private int[] gridVals;

    public Randomizer() {
        gridVals = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    public int[] randomize() {
        Random rand = new Random();

        for (int i = 0; i < gridVals.length; i++) {
            int randomIndexToSwap = rand.nextInt(gridVals.length);
            int temp = gridVals[randomIndexToSwap];
            gridVals[randomIndexToSwap] = gridVals[i];
            gridVals[i] = temp;
        }
        return gridVals;
    }
}