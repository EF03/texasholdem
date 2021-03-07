package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

public class CardSuitEnumTest {

    @Test
    public void testGetName() {

        CardSuitEnum cardSuit1 = CardSuitEnum.HEARTS;
        CardSuitEnum cardSuit2 = CardSuitEnum.DIAMONDS;
        CardSuitEnum cardSuit3 = CardSuitEnum.SPADES;
        CardSuitEnum cardSuit4 = CardSuitEnum.CLUBS;

        Assert.assertEquals(cardSuit1.getName(), "♥");
        Assert.assertEquals(cardSuit2.getName(), "♦");
        Assert.assertEquals(cardSuit3.getName(), "♠");
        Assert.assertEquals(cardSuit4.getName(), "♣");
    }

}
