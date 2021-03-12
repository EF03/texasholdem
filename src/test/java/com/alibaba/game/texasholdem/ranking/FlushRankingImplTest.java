package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.*;
import org.junit.Assert;
import org.junit.Test;

public class FlushRankingImplTest {


    @Test
    public void testIsFlushRanking() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card8 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);

        Card otherSuitCard = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TEN);

        Player p = new Player();
        p.addCard(card8);
        p.addCard(card10);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card13);

        IRanking ranking = new FlushRankingImpl();

        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);

        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FLUSH);

        Player p2 = new Player();
        p2.addCard(card8);
        p2.addCard(card10);
        p2.addCard(card11);
        p2.addCard(card12);
        p2.addCard(otherSuitCard);

        IRanking ranking2 = new FlushRankingImpl();

        RankingResult result2 = ranking2.resolve(p2);
        Assert.assertNull(result2);

    }

    @Test
    public void testIsFlushRanking2() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card8 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_EIGHT);
        Card card7 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card6 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SIX);

        Player p = new Player();
        p.addCard(card8);
        p.addCard(card10);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card13);
        p.addCard(card7);
        p.addCard(card6);

        IRanking ranking = new FlushRankingImpl();
        RankingResult result = ranking.resolve(p);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FLUSH);
    }

    @Test
    public void testIsFlushRanking3() {

        Card card13 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_KING);
        Card card12 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_QUEUE);
        Card card11 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card10 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TEN);
        Card card8 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_EIGHT);
        Card card7 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_SEVEN);
        Card card6 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_SIX);

        Player p = new Player();
        p.addCard(card8);
        p.addCard(card10);
        p.addCard(card11);
        p.addCard(card12);
        p.addCard(card13);
        p.addCard(card7);
        p.addCard(card6);

        IRanking ranking = new FlushRankingImpl();
        RankingResult result = ranking.resolve(p);
        Assert.assertNull(result);
    }

}
