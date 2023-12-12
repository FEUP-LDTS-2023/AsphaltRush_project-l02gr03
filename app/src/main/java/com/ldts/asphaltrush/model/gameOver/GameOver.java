package com.ldts.asphaltrush.model.gameOver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> entries;
    private String name = "";
    private long points;
    private int currentEntry = 0;

    public GameOver(long points) {
        this.entries = new ArrayList<>(Arrays.asList("Confirm", "Back"));
        this.entries.addAll(generateLetters());
        this.points = points;
    }

    private List<String> generateLetters() {
        List<String> generatedLetters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            generatedLetters.add(String.valueOf(letter));
        }
        generatedLetters.add("-");
        return generatedLetters;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public String getCurrentEntry() {
        return entries.get(currentEntry);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedConfirm() {
        return isSelected(0);
    }

    public boolean isSelectedBackToMenu() {
        return isSelected(1);
    }

    public boolean isSelectedDelete() {
        return isSelected(28);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public long getPoints() {
        return this.points;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveLeft() {
        currentEntry--;
        if (currentEntry < 3)
            currentEntry = this.entries.size() - 1;
        else if (currentEntry >= 3 && (currentEntry % 7) + 3 == 0) {
            currentEntry -= 7;
        }
    }

    public void moveRight() {
        currentEntry++;
        if (currentEntry >= this.entries.size())
            currentEntry = 3;
        else if (currentEntry >= 3 && (currentEntry % 7) + 3 == 0) {
            currentEntry += 7;
        }
    }

    public void moveDown() {
        if(currentEntry<3) currentEntry++;
        else {
            currentEntry += 7;

            if (currentEntry > this.entries.size()-1)
                currentEntry = 0;
        }
    }

    public void moveUp() {
        if(currentEntry<=0) currentEntry=entries.size()-1;
        else if(currentEntry<3) currentEntry--;
        else if (currentEntry < 7+3) currentEntry = 2;
        else {
            currentEntry -= 7;
            if (currentEntry < 0)
                currentEntry = this.entries.size() - 1 - (Math.abs(currentEntry) % 7);
        }
    }
}
