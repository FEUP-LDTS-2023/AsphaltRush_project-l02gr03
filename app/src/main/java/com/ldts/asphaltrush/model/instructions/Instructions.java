package com.ldts.asphaltrush.model.instructions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instructions {
    private final List<String> entries;
    private int currentEntry = 0;

    public Instructions() {
        this.entries = Arrays.asList("Back");
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedBack() {
        return isSelected(0);
    }
}
