package com.entertainment;

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


    public String toString() {
        return getClass().getSimpleName() + " [brand=" + getBrand() +
                ", volume=" + getVolume() + ", currentChannel=" + getCurrentChannel() + "]";
    }


}