package com.ldts.asphaltrush.model.garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garage {
    private final List<String> entries;
    private int currentEntry = 0;

    public Garage() {
        this.entries = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8"));
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

    public void moveUp() {
        if (currentEntry <= 2) currentEntry += 6;
        else currentEntry -= 3;
    }

    public void moveDown() {
        if (currentEntry >= 6) currentEntry -= 6;
        else currentEntry += 3;
    }

    public void moveLeft() {
        if(currentEntry == 0 || currentEntry == 3 || currentEntry == 6) currentEntry += 2;
        else currentEntry--;
    }

    public void moveRight() {
        if(currentEntry == 2 || currentEntry == 5 || currentEntry == 8) currentEntry -= 2;
        else currentEntry++;
    }

}
