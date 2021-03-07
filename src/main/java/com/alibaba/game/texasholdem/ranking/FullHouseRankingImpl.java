package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code FullHouseRankingImpl}
 * 解析玩家手中的牌是不是三条+一对
 *
 * @author fm035
 */
public class FullHouseRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        boolean isFullHouse = false;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        if (rankCount.size() == 2) {
            Collection<Integer> values = rankCount.values();
            for (int value : values) {
                if (value == 2 || value == 3) {
                    isFullHouse = true;
                    break;
                }
            }
        }

        if (isFullHouse) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FULL_HOUSE);
        }

        return result;
    }

}
