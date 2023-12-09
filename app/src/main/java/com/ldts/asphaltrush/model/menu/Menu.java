package com.ldts.asphaltrush.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;



    private String currentCar = "0";

    public Menu() {
        this.entries = Arrays.asList("Start", "Garage" , "Ranking", "Exit");
    }

    public Menu(String currentCar){
        this.entries = Arrays.asList("Start", "Garage" , "Ranking", "Exit");
        this.currentCar = currentCar;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getCurrentCar() {
        return currentCar;
    }
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedGarage()  {
        return isSelected(1);
    }

    public boolean isSelectedRanking()  {
        return isSelected(2);
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }
}
