package com.ldts.asphaltrush.model.garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garage {
    private final List<String> entries;
    private int currentEntry = 0;
    private int currentCar = 0;
    private static final int NUMBEROFCARS = 3;

    public Garage() {
        this.entries = new ArrayList<>(Arrays.asList("Confirm"));
    }

    public int getCurrentCar(){
        return currentCar;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }


    public void moveLeft() {
        currentCar = (currentCar-1+NUMBEROFCARS)%NUMBEROFCARS;
    }

    public void moveRight() {
        currentCar = (currentCar+1)%NUMBEROFCARS;
    }

}
