package com.ldts.asphaltrush.model.ranking;

import java.io.*;
import java.util.*;

public class Ranking {
    private final List<String> entries;
    private int currentEntry = 0;
    private ArrayList<String[]> ranking;

    public Ranking() {
        this.entries = Arrays.asList("Back");
        try {
            ranking = readRanking();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String[]> getRanking(){
        return ranking;
    }
    public ArrayList<String[]>  readRanking() throws IOException {

        String path = "data/Rankings.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        ArrayList<String[]> ranking = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] namePoints = line.split(":");
            ranking.add(namePoints);
        }

        return ranking;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }

}
