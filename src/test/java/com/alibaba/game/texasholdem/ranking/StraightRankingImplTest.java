package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class StraightRankingImplTest {


    @Test
    public void testIsStraightRanking1() {

        Card card13 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card9 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_NINE);

        Player p = new Player();
        p.addCard(card9);
        p.addCard(card10);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card13);

        IRanking ranking = new StraightRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.STRAIGHT);
    }

    @Test
    public void testIsStraightRanking2() {

        Card card12 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card9 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_NINE);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card9);
        p2.addCard(card10);
        p2.addCard(card11);
        p2.addCard(card12);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new StraightRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

}
