package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.*;
import com.alibaba.game.texasholdem.ranking.FlushRankingImpl;
import com.alibaba.game.texasholdem.ranking.IRanking;
import com.alibaba.game.texasholdem.ranking.RankingResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * 同花比较器
 */
public class FlushComparingImplTest {

    @Test
    public void testComparing1() {
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card4 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FIVE);
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_THREE);
        Card card3 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);

        Player p = new Player();
        p.addCard(card1);
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card4);
        p.addCard(card5);

        IRanking ranking = new FlushRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FLUSH);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TWO);
        Card card22 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_THREE);
        Card card23 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FIVE);
        Card card24 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_SEVEN);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);

        IRanking ranking2 = new FlushRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.FLUSH);

        Assert.assertEquals(1, p.compareTo(p2));
    }

    @Test
    public void testComparing2() {
        Card card5 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_JACK);
        Card card4 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_SEVEN);
        Card card3 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_FIVE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_THREE);
        Card card1 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_TWO);
        Card cardD2 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TWO);
        Card cardD22 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_TWO);

        Player p = new Player();
        p.addCard(card2);
        p.addCard(card3);
        p.addCard(card1);
        p.addCard(card4);
        p.addCard(card5);
        p.addCard(cardD2);
        p.addCard(cardD22);

        IRanking ranking = new FlushRankingImpl();
        RankingResult result = ranking.resolve(p);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getRankingEnum(), RankingEnum.FLUSH);


        Card card21 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_TWO);
        Card card22 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_THREE);
        Card card23 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_FIVE);
        Card card24 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_SEVEN);
        Card card25 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_QUEUE);
        Card card26 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_KING);
        Card card27 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);

        Player p2 = new Player();
        p2.addCard(card21);
        p2.addCard(card22);
        p2.addCard(card23);
        p2.addCard(card24);
        p2.addCard(card25);
        p2.addCard(card26);
        p2.addCard(card27);

        IRanking ranking2 = new FlushRankingImpl();
        RankingResult result2 = ranking2.resolve(p2);

        Assert.assertNotNull(result2);
        Assert.assertEquals(result2.getRankingEnum(), RankingEnum.FLUSH);

        Assert.assertEquals(1, p.compareTo(p2));
    }
}
