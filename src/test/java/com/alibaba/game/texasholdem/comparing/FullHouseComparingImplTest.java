package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.FullHouseRankingImpl;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import org.junit.Assert;
import org.junit.Test;

public class FullHouseComparingImplTest {

    @Test
    public void testComparing() {
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FOUR);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FOUR);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_FOUR);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new FullHouseRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FULL_HOUSE);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TWO);
        Card card22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TWO);
        Card card23 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_TWO);
        Card card24 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TEN);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new FullHouseRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.FULL_HOUSE);

        Assert.assertEquals(-1, p.compareTo(p2));
    }
}
