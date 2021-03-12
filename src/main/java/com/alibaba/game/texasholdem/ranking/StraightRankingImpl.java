package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;

/**
 * Class {@code StraightRankingImpl}
 * 解析玩家手中的牌是不是顺子
 *
 * @author fm035
 */
public class StraightRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        // 如果是同色
        if (!this.isSameSuit(cards)) {
            boolean isStraight = this.isStraight(player);
            if (isStraight) {
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.STRAIGHT);
            }
        }
        return result;
    }

}
