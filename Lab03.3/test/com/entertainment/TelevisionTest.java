package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    // business object(s) under test
    private Television tv;
    private Television tv1;      // for equals and hashcode testing
    private Television tv2;     // for equals and hashcode testing

    @Before
    public void setUp(){
        tv = new Television();
        tv1 = new Television("sony", 50, DisplayType.OLED);
        tv2 = new Television("sony", 50, DisplayType.OLED);
    }





    @Test
    public void hashCode_shouldReturnSameValue_equalObjects() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void changeChannel_shouldStoreVolume_whenValid_lowerBound() throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldStoreVolume_whenValid_upperBound() throws InvalidChannelException {
        tv.changeChannel(1000);
    }

    @Test
    public void changeChannel_lowerBound_shouldThrow_invalidChannelException() throws InvalidChannelException {
        try{
            tv.changeChannel(0);
            fail("should have thrown InvalidChannelException");
        } catch( InvalidChannelException e) {
            assertEquals("Invalid channel: " + 0 + ". " +
                    "Allowed range: [" + 1 + "," + 999 + "].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_upperBound_shouldThrow_invalidChannelException() throws InvalidChannelException {
        try {
            tv.changeChannel(1000);
            fail("Should have thrown InvalidChannelException");
        } catch(InvalidChannelException e) {
            assertEquals("Invalid channel: " + 1000 + ". " +
                    "Allowed range: [" + 1 + "," + 999 + "].", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_lowerBound_illegalArgumentException() {
        tv.setVolume(-1);
    }


    @Test
    public void setVolume_upperBound_illegalArgumentException() {
        try {
            tv.setVolume(101);
            fail("Should have throw IllegalArgumentException");

        } catch(IllegalArgumentException e) {
            assertEquals("Invalid volume: " + 101 + ". " +   // how to get setVolume() from above or have to hard code?
                    "Allowed range: [" + Television.MIN_VOLUME + "," + Television.MAX_VOLUME + "].", e.getMessage());
        }
    }



    @Test
    public void setVolume_shouldStoreVolume_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_lowerBound() {      // testing to see if when we set the volume will it hold the value
        tv.setVolume(0);                                            // set volume
        assertEquals(0, tv.getVolume());                    // call assertEquals and pass expected value and call getter on volume to compare values
    }


}