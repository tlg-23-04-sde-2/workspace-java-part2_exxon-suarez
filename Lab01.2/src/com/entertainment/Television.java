package com.entertainment;

import java.util.Objects;


/*
 * natural order is defined by brand (String).
 *  **** be consistent with equals, natural order must use the same properties that are used in equals(). ****
 */

public class Television implements Comparable<Television> {

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

    // natural order is defined by brand(String) then by volume(int)
    // to be consistent with equals we must use the same properties for natural order that we use for equals() and hashCode()
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if( result == 0 ) {      // tied on brand, break the tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }

        return result;
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