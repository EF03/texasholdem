package com.alibaba.game.texasholdem;

import com.alibaba.game.texasholdem.comparing.ComparingFacade;
import com.alibaba.game.texasholdem.comparing.IComparing;
import com.alibaba.game.texasholdem.ranking.RankingResult;

import java.util.*;

/**
 * Class {@code Player} 一个玩家, 持有7张牌, 并伴随牌型的属性.
 *
 * @author fm035
 */
public class Player implements Comparable<Player> {

    /**
     * 玩家手上的7张牌
     */
    private final List<Card> cards;
    /**
     * 玩家手上的7张牌 為排序
     */
    private final List<Card> originCards;
    /**
     * 牌型校验结果
     */
    private RankingResult rankingResult;
    /**
     * 玩家状态
     */
    private TexasPlayerStatusEnum status;
    /**
     * 玩家編號
     */
    private int playerId;

    public Player() {
        this.originCards = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    /**
     * @return 获得手上的牌的张数
     */
    public int getCardSize() {
        return this.cards.size();
    }

    /**
     * @param card 增加手牌
     */
    public void addCard(Card card) {
        this.cards.add(card);
        this.originCards.add(card);
//        Collections.sort(this.cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public RankingResult getRankingResult() {
        if (rankingResult == null) {
            rankingResult = new RankingResult();
            rankingResult.setRankingEnum(RankingEnum.HIGH_CARD);
            rankingResult.setHighCard(this.cards.get(0));
        }
        return rankingResult;
    }

    public Map<Integer, Integer> getCardsRankCountMap() {
        List<Card> cards = this.getCards();
//        System.out.println("cards = " + cards);
        Map<Integer, Integer> rankCount = new HashMap<>(7);
        for (Card card : cards) {
            Integer number = card.getRank().getNumber();
            if (!rankCount.containsKey(number)) {
                rankCount.put(number, 1);
            } else {
                rankCount.put(number, rankCount.get(number) + 1);
            }
        }
        return rankCount;
    }

    public void setRankingResult(RankingResult rankingResult) {
        this.rankingResult = rankingResult;
    }

    @Override
    public int compareTo(Player o) {
        int selfPriority = this.getRankingResult().getRankingEnum().getPriority();
        int otherPriority = o.getRankingResult().getRankingEnum().getPriority();

        if (selfPriority < otherPriority) {
            return 1;
        }
        if (selfPriority > otherPriority) {
            return -1;
        }

        IComparing cmp = ComparingFacade.getComparing(this.getRankingResult().getRankingEnum());
        return cmp.compare(this, o);
    }

    public TexasPlayerStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TexasPlayerStatusEnum status) {
        this.status = status;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", cards=" + cards +
                ", originCards=" + originCards +
                ", rankingResult=" + rankingResult +
                '}';
    }
}
