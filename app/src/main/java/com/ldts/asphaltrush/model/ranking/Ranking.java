package com.ldts.asphaltrush.model.ranking;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Ranking {
    private final List<String> entries;
    private int currentEntry = 0;

    private TreeSet<Pair<String, Long>> rankingsSet = new TreeSet<>(Comparator
            .<Pair<String, Long>>comparingLong(pair -> pair.getSecond())
            .reversed()
            .thenComparing(pair -> pair.getFirst()));

    public Ranking() {
        this.entries = Arrays.asList("Back");
    }

    public ArrayList<String[]> getRankingAsText() throws IOException {
        BufferedReader objReader = null;

        String fileName = "Rankings.txt";

        // Get the resource as a stream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        // Check if the resource exists
        if (inputStream == null) {
            return null;
        }

        objReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        ArrayList<String[]> rankingAsText = new ArrayList<>();

        // get values from Rankings.txt and insert them into rankingAsText
        while ((line = objReader.readLine()) != null) {
            String[] arr = line.split(":");
            // add the values to the list
            rankingAsText.add(arr);
        }

        objReader.close();

        return rankingAsText;
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

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void addRanking(String name, long points) throws IOException, URISyntaxException {

        // get the current ranking and see if the new player enters the champions ranking
        rankingsSet.clear();
        BufferedReader objReader = null;

        String fileName = "Rankings.txt";

        // Get the resource as a stream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        // Check if the resource exists
        if (inputStream != null) {
            objReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            // get values from Rankings.txt and insert them into rankingsSet
            while ((line = objReader.readLine()) != null) {
                String[] arr = line.split(":");
                // add the values to the set
                rankingsSet.add(new Pair(arr[0], Long.parseLong(arr[1])));
            }

            objReader.close();
        }

        // add new score to the ranking set
        if (!name.equals("")) rankingsSet.add(new Pair(name, points));

        updateRankingFile();
    }

    public void updateRankingFile() throws IOException, URISyntaxException {
        BufferedWriter writer = null;

        String fileName = "Rankings.txt";

        // Get the resource URL
        URL resourceUrl = getClass().getClassLoader().getResource(fileName);

        // Check if the resource URL exists
        if (resourceUrl != null) {
            File file = new File(((URL) resourceUrl).toURI());
            writer = new BufferedWriter(new FileWriter(file));
            String champions = "";

            // by writing the 5 first players, we get the champions
            for (int k = 1; k <= 5; k++) {
                if (rankingsSet.isEmpty()) break;
                champions = champions + rankingsSet.first().getFirst() + ":" + rankingsSet.first().getSecond() + "\n";
                rankingsSet.remove(rankingsSet.first());
            }

            writer.write(champions);
            writer.close();
        }
    }
}
