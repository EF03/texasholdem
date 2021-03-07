package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.CardRankEnum;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code RoyalFlushRankingImpl}
 * 解析玩家手中的牌是不是皇家同花顺(即是 10 J Q K A 且同色)
 * @author fm035
 */
public class RoyalFlushRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        // 如果是同色
        if (this.isSameSuit(cards)) {
            List<CardRankEnum> ranks = new ArrayList<CardRankEnum>();
            for (Card card : cards) {
                ranks.add(card.getRank());
            }
            // 且是10 J Q K A
            if (ranks.contains(CardRankEnum.CARD_TEN)
                    && ranks.contains(CardRankEnum.CARD_JACK)
                    && ranks.contains(CardRankEnum.CARD_QUEUE)
                    && ranks.contains(CardRankEnum.CARD_KING)
                    && ranks.contains(CardRankEnum.CARD_ACE)) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.ROYAL_FLUSH);
            }
        }

        return result;
    }

}
