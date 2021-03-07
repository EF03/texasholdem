package com.alibaba.game.texasholdem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {

    @Test
    public void testEquals() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        Assert.assertEquals(card, card);
        Assert.assertEquals(card, card2);
        Assert.assertNotSame(card, card3);
    }

    @Test
    public void testHashcode() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card3 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_ACE);

        Assert.assertEquals(card.hashCode(), card.hashCode());
        Assert.assertEquals(card.hashCode(), card2.hashCode());
        Assert.assertNotEquals(card.hashCode(), card3.hashCode());
    }

    @Test
    public void testToString() {

        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_JACK);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);
        Card card4 = new Card(CardSuitEnum.CLUBS, CardRankEnum.CARD_KING);

        Assert.assertEquals(card.toString(), "♥14");
        Assert.assertEquals(card2.toString(), "♠11");
        Assert.assertEquals(card3.toString(), "♦12");
        Assert.assertEquals(card4.toString(), "♣13");
    }

    @Test
    public void testCompareTo() {
        List<Card> cards = new ArrayList<Card>();
        Card card = new Card(CardSuitEnum.HEARTS, CardRankEnum.CARD_ACE);
        Card card2 = new Card(CardSuitEnum.SPADES, CardRankEnum.CARD_KING);
        Card card3 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_QUEUE);

        cards.add(card);
        cards.add(card2);
        cards.add(card3);

        Collections.sort(cards);

        Assert.assertEquals(card, cards.get(0));
        Assert.assertEquals(card2, cards.get(1));
        Assert.assertEquals(card3, cards.get(2));
    }

}
