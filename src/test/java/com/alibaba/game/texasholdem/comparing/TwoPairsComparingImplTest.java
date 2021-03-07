package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import com.alibaba.game.texasholdem.ranking.TwoPairsRankingImpl;
import org.junit.Assert;
import org.junit.Test;

public class TwoPairsComparingImplTest {

    @Test
    public void testComparingTwoSamePairs() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new TwoPairsRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new TwoPairsRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.TWO_PAIR);

        Assert.assertEquals(-1, p.compareTo(p2));
    }

    @Test
    public void testComparingNotSamePairs() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new TwoPairsRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new TwoPairsRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.TWO_PAIR);

        Assert.assertEquals(-1, p.compareTo(p2));
    }

    @Test
    public void testComparingNotSamePairs1() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new TwoPairsRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new TwoPairsRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.TWO_PAIR);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparingNotSamePairs2() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new TwoPairsRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.TWO_PAIR);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new TwoPairsRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.TWO_PAIR);

        Assert.assertEquals(0, p.compareTo(p2));
    }
}
