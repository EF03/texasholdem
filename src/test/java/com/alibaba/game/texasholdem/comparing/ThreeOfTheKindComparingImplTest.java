package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import com.alibaba.game.texasholdem.ranking.ThreeOfTheKindRankingImpl;
import org.junit.Assert;
import org.junit.Test;

public class ThreeOfTheKindComparingImplTest {

    @Test
    public void testComparing() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new ThreeOfTheKindRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_NINE);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_NINE);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_NINE);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparingSame1() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new ThreeOfTheKindRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparingSame2() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);
        p.addCard(card6);
        p.addCard(card7);

        IRanking ranking = new ThreeOfTheKindRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card26 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card27 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);
        p2.addCard(card26);
        p2.addCard(card27);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparingSame3() {
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TEN);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_SEVEN);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FIVE);
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);
        p.addCard(card6);
        p.addCard(card7);

        IRanking ranking = new ThreeOfTheKindRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);


        Card card27 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);
        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card26 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_EIGHT);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_FOUR);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);
        p2.addCard(card26);
        p2.addCard(card27);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparingSame4() {
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TEN);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);
        p.addCard(card6);
        p.addCard(card7);

        IRanking ranking = new ThreeOfTheKindRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);


        Card card27 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TWO);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TWO);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card26 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);
        p2.addCard(card26);
        p2.addCard(card27);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Assert.assertEquals(-1, p.compareTo(p2));
    }
}
