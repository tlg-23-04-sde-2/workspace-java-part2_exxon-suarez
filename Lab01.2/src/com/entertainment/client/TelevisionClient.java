package com.entertainment.client;
import com.entertainment.Television;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv = new Television("sony", 32);
        tv.changeChannel(5);
        System.out.println(tv);
        System.out.println(tv1);
    }
}