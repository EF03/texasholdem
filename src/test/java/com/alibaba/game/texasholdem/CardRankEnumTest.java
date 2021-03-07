package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

public class CardRankEnumTest {

    @Test
    public void testGetNumber() {

        CardRankEnum cardRank1 = CardRankEnum.CARD_ACE;
        CardRankEnum cardRank2 = CardRankEnum.CARD_TWO;
        CardRankEnum cardRank3 = CardRankEnum.CARD_TEN;

        Assert.assertEquals(14, cardRank1.getNumber().intValue());
        Assert.assertEquals(2, cardRank2.getNumber().intValue());
        Assert.assertEquals(10, cardRank3.getNumber().intValue());
    }

}
