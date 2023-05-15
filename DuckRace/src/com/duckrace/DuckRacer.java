package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    private int id;
    private String name;
    private int wins;
    private List<Reward> rewards = new ArrayList<>();               // a List of rewards


    // constructors
    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }



    // business / action methods

    public void win(Reward reward) {             // already has information of racer because its called from an instance we created already
        rewards.add(reward);
    }



    // accessor methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // this is a derived property   , dont need to store it as a field its referenced from rewards.size
    public int getWins() {
        return rewards.size();
    }

    /*
     *
     *
     * Instead of returning direct reference to our internal List<Reward> we return read-only view. so client cant modify our List
     */

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);               // this syntax wraps our List of rewards as a read-only view which still references any updated information
    }


    @Override
    public String toString() {
        return String.format("%s, name=%s, wins=%s, rewards=%s, rewards=%s", getClass().getSimpleName(), getId(), getName(),getWins(), getRewards());
    }
}