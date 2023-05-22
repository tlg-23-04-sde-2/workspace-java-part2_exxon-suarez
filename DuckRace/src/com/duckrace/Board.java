package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    /*
     * Updates the board (racerMap) by making a duck racer win
     * this could mean fetching an existing racer from racer map or we might need to create a new duck racer and put it in the map
     * either way we need to make it win
     */

    public void update(int id, Reward reward) {
        DuckRacer racer = null;              // declare it here so its visible in and outside the for loop
        if(racerMap.containsKey(id)) {      //if the id exists in raceMap
            racer = racerMap.get(id);
        } else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id,racer);

        }

        racer.win(reward);
    }

    //FOR TESTING PURPOSES
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        // read all lines from conf/student -ids.csv

        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
            // for each line in the file split it into tokens
            for(String line : lines) {
                String[] tokens = line.split(","); // ["1", "Bullen"]        // splitting each string into an array named tokens seperated by , comma
                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);  // putting our new tokens into our idMap, wrapping them in Iteger to convert first then getting them by array from tokens array

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }

    public int getRacersSize() {
        return studentIdMap.size();
    }

    public void show() {
        Collection<DuckRacer> racers = racerMap.values();

        System.out.println("Duck Race Results");
        System.out.println("============\n");
        System.out.println("id  name wins rewards");
        System.out.println(" -- ---- ---- -------");
        for(DuckRacer racer : racers) {
            String rewardsString = racer.getRewards().toString();
            String rewards = rewardsString.substring(1, rewardsString.length() - 1);
            System.out.printf("%s %s %s %s \n",racer.getId(), racer.getName(), racer.getWins(), rewards);  // toString automatically called
        }
    }
}