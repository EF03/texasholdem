package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class FullHouseRankingImplTest {


    @Test
    public void testIsFullHouseRanking1() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card131313 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card9 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_NINE);
        Card card99 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card131313);
        p.addCard(card99);
        p.addCard(card9);

        IRanking ranking = new FullHouseRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FULL_HOUSE);

    }

    @Test
    public void testIsFullHouseRanking2() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card131313 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card9 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_NINE);
//        Card card99 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card13);
        p2.addCard(card1313);
        p2.addCard(card131313);
        p2.addCard(card9);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new FullHouseRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

    /**
     * 測試兩個三條是否同花
     */
    @Test
    public void testIsFullHouseRanking3() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card1313 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card131313 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card9 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_NINE);
        Card card99 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);
        Card card999 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_NINE);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card13);
        p.addCard(card1313);
        p.addCard(card131313);
        p.addCard(card9);
        p.addCard(card99);
        p.addCard(card999);
        p.addCard(otherSuitCard);


    }

}
