package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Constants;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.Collection;
import java.util.Map;

/**
 * Class {@code FourOfTheKindRankingImpl}
 * 解析玩家手中的牌是不是四条(四张连续相同的牌)
 *
 * @author fm035
 */
public class FourOfTheKindRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasFour = false;
        Collection<Integer> values = rankCount.values();
        for (int value : values) {
            if (value == Constants.COMPARE_CARD_NUMBERS - 1) {
                hasFour = true;
                break;
            }
        }

        if (hasFour) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FOUR_OF_THE_KIND);
        }

        return result;
    }

}
