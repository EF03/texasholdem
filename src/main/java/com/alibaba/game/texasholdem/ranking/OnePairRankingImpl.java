package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code OnePairRankingImpl}
 * 解析玩家手中的牌是不是一对(2+1+1+1)
 * @author fm035
 */
public class OnePairRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasOne = false;

        if (rankCount.size() == 4) {
            Collection<Integer> values = rankCount.values();
            for (int value : values) {
                if (value == 2 || value == 1) {
                    hasOne = true;
                    break;
                }
            }
        }

        if (hasOne) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.ONE_PAIR);
        }

        return result;
    }

}
