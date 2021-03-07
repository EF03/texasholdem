package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code TwoPairsRankingImpl}
 * 解析玩家手中的牌是不是两对(2+2+1)
 *
 * @author fm035
 */
public class TwoPairsRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasTwo = false;
        int countTwo = 0;
        if (rankCount.size() <= 4) {
            Collection<Integer> values = rankCount.values();
            for (int value : values) {
                if (value == 2) {
                    countTwo++;
                }
                if (countTwo >= 2) {
                    hasTwo = true;
                    break;
                }
            }
        }

        if (hasTwo) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.TWO_PAIR);
        }

        return result;
    }

}
