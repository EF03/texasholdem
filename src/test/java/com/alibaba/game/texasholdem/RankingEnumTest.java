package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

public class RankingEnumTest {

    @Test
    public void testGetNumber() {

        RankingEnum ruleRanking1 = RankingEnum.FLUSH;

        Assert.assertEquals(ruleRanking1.getType(), "同花");
        Assert.assertEquals(ruleRanking1.getPriority(), 600);
    }

}
