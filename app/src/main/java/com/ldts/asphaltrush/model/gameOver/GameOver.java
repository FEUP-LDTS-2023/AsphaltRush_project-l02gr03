package com.ldts.asphaltrush.model.gameOver;

import com.ldts.asphaltrush.model.ImageFactory;
import com.ldts.asphaltrush.model.ranking.Pair;

import java.io.*;
import java.net.URL;
import java.util.*;

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
        if (currentEntry > 1) {
            currentEntry--;
            if ((currentEntry + 5) % 7 == 6) {
                currentEntry += 7;
                if (currentEntry > getNumberEntries() - 1) currentEntry = getNumberEntries() - 1;
            }
        }
    }

    public void moveRight() {
        if (currentEntry > 1) {
            currentEntry++;
            if ((currentEntry + 5) % 7 == 0) {
                currentEntry -= 7;
            }
            if (currentEntry > getNumberEntries() - 1) currentEntry = 23;
        }
    }

    public void moveDown() {
        if(currentEntry == 0) currentEntry++;
        else if(currentEntry >=2){
            currentEntry += 7;
            if (currentEntry > this.entries.size()-1)
                currentEntry = 0;
        }
    }

    public void moveUp() {
        if(currentEntry==0) currentEntry=entries.size()-1;
        else if(currentEntry==1) currentEntry--;
        else if (currentEntry >=9) currentEntry -=7;
    }

    public boolean isNameEmpty(){
        return Objects.equals(name, "");
    }

    public void saveRanking(){

        try {
            TreeSet<Pair<String, Long>> rankingsSet = readRankings();
            rankingsSet.add(new Pair<>(name, points));
            writeRanking(rankingsSet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void writeRanking(TreeSet<Pair<String, Long>> rankingSet) throws IOException {

        String path = "app/data/Rankings.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

            for (int k = 1; k <= 5; k++) {
                if (rankingSet.isEmpty()) break;
                bw.write(rankingSet.first().getFirst() + ":" + rankingSet.first().getSecond()+'\n');
                rankingSet.remove(rankingSet.first());
            }
            bw.close();
    }
    private TreeSet<Pair<String, Long>>  readRankings() throws IOException {
        TreeSet<Pair<String, Long>>  rankingSet = new  TreeSet<>(Comparator
                .<Pair<String, Long>>comparingLong(Pair::getSecond)
                .reversed()
                .thenComparing(Pair::getFirst));;

        String path = "app/data/Rankings.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;
        while ((line = br.readLine()) != null) {
            String[] namePoints = line.split(":");
            rankingSet.add(new Pair(namePoints[0], Long.parseLong(namePoints[1])));
        }

        return rankingSet;
    }

}
