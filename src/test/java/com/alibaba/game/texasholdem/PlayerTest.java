package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class PlayerTest {

    @Test
    public void testAddCard() {
        Poker poker = new Poker();
        Player player = new Player();
        for (int i = 0; i < Constants.HAND_CARD_NUMBERS; i++) {
            player.addCard(poker.dispatch());
        }
        Assert.assertEquals(Constants.HAND_CARD_NUMBERS, player.getCardSize());
    }

    @Test
    public void testGetCardsRankCountMap() {
        Player player = new Player();

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_JACK);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);
        Card card5 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);

        player.addCard(card);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);
        player.addCard(card5);

        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        Assert.assertEquals(2, rankCount.get(CardRankEnum.CARD_KING.getNumber()).intValue());
        Assert.assertEquals(1, rankCount.get(CardRankEnum.CARD_ACE.getNumber()).intValue());
        Assert.assertEquals(1, rankCount.get(CardRankEnum.CARD_QUEUE.getNumber()).intValue());
        Assert.assertEquals(1, rankCount.get(CardRankEnum.CARD_JACK.getNumber()).intValue());
    }

}
