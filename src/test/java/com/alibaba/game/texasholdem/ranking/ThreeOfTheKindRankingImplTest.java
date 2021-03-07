package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class ThreeOfTheKindRankingImplTest {


    @Test
    public void testIsThreeOfTheKindRanking() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card131313 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card8 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_EIGHT);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card131313);
        p.addCard(card8);
        p.addCard(card9);

        IRanking ranking = new ThreeOfTheKindRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card1313);
        p2.addCard(card8);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

    @Test
    public void testIsThreeOfTheKindRanking1() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card131313 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card8 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_EIGHT);
        Card card9 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SIX);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card131313);
        p.addCard(card8);
        p.addCard(card9);
        p.addCard(card7);
        p.addCard(card6);

        IRanking ranking = new ThreeOfTheKindRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.THREE_OF_THE_KIND);

        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card1313);
        p2.addCard(card8);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new ThreeOfTheKindRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

}
