package com.crisp;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red", 1.0, 2.2, 3));
        radishes.add(new Radish("black", 3.5, 0.0, 0));
        radishes.add(new Radish("red", 0.75, 3.1, 7));
        radishes.add(new Radish("white", 1.0, 1.0, 2));

        radishes.sort(null); // passing null means natural order

        System.out.println("natural order (size)");
        dump(radishes);
        System.out.println();

        radishes.sort(new RadishColorComparator());    // pass a new instance of RadishColorComparator to the sort method ( which takes our newly created radishes and compares them by natural color order )
        System.out.println("Color");
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for( Radish radish : radishList) {                  // for each loop
            System.out.println(radish);
        }
    }
}