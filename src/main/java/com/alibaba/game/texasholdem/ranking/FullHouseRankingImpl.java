package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code FullHouseRankingImpl}
 * 解析玩家手中的牌是不是三条+一对+1+1
 *
 * @author fm035
 */
public class FullHouseRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        boolean isFullHouse = false;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();
        int countTwo = 0;
        int countThree = 0;
        if (rankCount.size() <= 4) {
            Collection<Integer> values = rankCount.values();
            for (int value : values) {
                if (value == 2) {
                    countTwo++;
                }
                if (value == 3) {
                    countThree++;
                }
            }
        }
        if (countTwo >= 1 && countThree >= 1 || countThree >= 2) {
            isFullHouse = true;
        }

        if (isFullHouse) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FULL_HOUSE);
        }

        return result;
    }

}
