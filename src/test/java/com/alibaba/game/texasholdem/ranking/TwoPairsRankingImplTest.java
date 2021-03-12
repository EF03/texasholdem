package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class TwoPairsRankingImplTest {


    @Test
    public void testIsTwoPairsRanking() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card1212 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_QUEUE);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);
        Card card22 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card1212);
        p.addCard(card12);
        p.addCard(card9);
        p.addCard(card2);
        p.addCard(card22);

        IRanking ranking = new TwoPairsRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);

        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card1313);
        p2.addCard(card12);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);
        p2.addCard(card2);
        p2.addCard(card22);

        IRanking ranking2 = new TwoPairsRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNotNull(result2);

        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.TWO_PAIR);

    }

    @Test
    public void testIsTwoPairsRanking1() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card1212 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_QUEUE);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);
        Card cardA = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);

//        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card1212);
        p.addCard(card12);
        p.addCard(card9);
        p.addCard(card2);
        p.addCard(cardA);

        IRanking ranking = new TwoPairsRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);

    }

    @Test
    public void testIsTwoPairsRanking2() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_JACK);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);
        Card cardA = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);

//        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card9);
        p.addCard(card2);
        p.addCard(cardA);

        IRanking ranking = new TwoPairsRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNull(result);

//        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);


    }

}
