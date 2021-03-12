package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class HighCardRankingImplTest {


    @Test
    public void testIsOnePairRanking1() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TEN);
        Card card8 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SIX);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card12);
        p.addCard(card11);
        p.addCard(card10);
        p.addCard(card8);
        p.addCard(card7);
        p.addCard(card6);

        IRanking ranking = new HighCardRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.HIGH_CARD);

    }

    @Test
    public void testIsOnePairRanking2() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TEN);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SIX);


        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card12);
        p2.addCard(card11);
        p2.addCard(card10);
        p2.addCard(card9);
        p2.addCard(card7);
        p2.addCard(card6);

        IRanking ranking2 = new HighCardRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

}
