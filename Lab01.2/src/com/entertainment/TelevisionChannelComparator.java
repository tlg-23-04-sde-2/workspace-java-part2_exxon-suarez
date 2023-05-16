package com.entertainment;

import java.util.Comparator;

public class TelevisionChannelComparator implements Comparator<Television> {

    @Override
    public int compare(Television c1, Television c2) {
        return Integer.compare(c1.getCurrentChannel(), c2.getCurrentChannel());
    }
}