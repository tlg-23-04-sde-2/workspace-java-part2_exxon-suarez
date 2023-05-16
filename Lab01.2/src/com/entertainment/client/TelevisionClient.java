package com.entertainment.client;
import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        Television tvA = new Television("sony" ,50);
        Television tvB = new Television("sony", 50);
        Television tvC = new Television("sony", 52);
        Television tvD = new Television("sony",12);

        System.out.println(tvA == tvB);
        System.out.println(tvA.equals(tvB));
        System.out.println();


        Set<Television> tvs = new TreeSet<>();          // TreeSet doesnt allows duplicates so now the length is 3
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The length of the set is: " + tvs.size());
        System.out.println();
        for(Television tv : tvs) {
            System.out.println(tv);
        }
    }
}