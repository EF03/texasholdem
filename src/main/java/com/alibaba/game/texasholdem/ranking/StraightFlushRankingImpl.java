package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;

/**
 * Class {@code StraightFlushRankingImpl}
 * 解析玩家手中的牌是不是同花顺(即是 最大牌是K 且同色)
 *
 * @author fm035
 */
public class StraightFlushRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        // 如果是同色
        if (this.isSameSuit(cards)) {
            boolean isStraight = this.isStraight(player);
            if (isStraight) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.STRAIGHT_FLUSH);
            }

        }

        return result;
    }

}
