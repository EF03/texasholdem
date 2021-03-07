package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.RankingEnum;

/**
 * Class {@code RankingResult} 牌型解析接口的返回值
 * @author fm035
 */
public class RankingResult {

    /**
     * 5张牌中最大的值
     */
    private Card highCard;
    /**
     * 牌型
     */
    private RankingEnum rankingEnum;

    public Card getHighCard() {
        return highCard;
    }

    public void setHighCard(Card highCard) {
        this.highCard = highCard;
    }

    public RankingEnum getRankingEnum() {
        return rankingEnum;
    }

    public void setRankingEnum(RankingEnum rankingEnum) {
        this.rankingEnum = rankingEnum;
    }

    @Override
    public String toString() {
        return "RankingResult{" +
                "rankingEnum=" + rankingEnum.getType() +
                '}';
    }
}
