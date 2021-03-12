package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code ThreeOfTheKindRankingImpl}
 * 解析玩家手中的牌是不是三条(3+1+1+1+1)
 *
 * @author fm035
 */
public class ThreeOfTheKindRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasThree = false;

        Collection<Integer> values = rankCount.values();
        if (rankCount.size() <= 5) {
            for (int value : values) {
                if (value == 3) {
                    hasThree = true;
                    break;
                }
            }
        }

        if (hasThree) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.THREE_OF_THE_KIND);
        }

        return result;
    }

}
