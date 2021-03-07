package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

public class PokerTest {

    @Test
    public void testGetSize() {
        Poker poker = new Poker();
        Assert.assertEquals(52, poker.getSize());
    }

    @Test
    public void testDispatch() {
        Poker poker = new Poker();

        poker.dispatch();
        Assert.assertEquals(51, poker.getSize());

        poker.dispatch();
        Assert.assertEquals(50, poker.getSize());
    }
}
