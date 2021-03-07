package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

public class DealerTest {

    @Test
    public void testDealer() {
        Player player1 = new Player();
        Player player2 = new Player();

        Dealer dealer = new Dealer(player1, player2);

        Assert.assertEquals(2, dealer.getPlayerSize());

        Player player3 = new Player();
        dealer.join(player3);
        Assert.assertEquals(3, dealer.getPlayerSize());

        dealer.start();
        Assert.assertEquals(5, player1.getCardSize());
        Assert.assertEquals(5, player2.getCardSize());
        Assert.assertEquals(5, player3.getCardSize());
    }

}
