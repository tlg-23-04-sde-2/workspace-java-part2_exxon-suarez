package com.entertainment;

import java.util.Objects;

public class Television {

    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();


    //constructors

    public Television() {

    }

    public Television (String brand, int volume) {
        setVolume(volume);
        setBrand(brand);
    }



    // business methods
    public int getCurrentChannel(){
        return tuner.getChannel();
    };

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    // Getters and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof Television) {
            Television  other = (Television) obj;

            result = Objects.equals(this.getBrand(), other.getBrand()) &&  // null safe check
                    this.getVolume() == other.getVolume();
        }
        return result;
    }

    @Override
    public int hashCode() {
//        return getBrand().length() + getVolume();
        // delegate to Objects.hash(), which uses a "good" hash function to minamize collisions
        return Objects.hash(getBrand(), getVolume());

    }



    public String toString() {
        return String.format("%s: brand:%s, volume=%s, currentChannel=%s", getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }



}