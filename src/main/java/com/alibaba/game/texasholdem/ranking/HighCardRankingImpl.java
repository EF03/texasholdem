package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Constants;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;
import java.util.Map;

/**
 * Class {@code HighCardRankingImpl}
 * 解析玩家手中的牌是不是单牌(1+1+1+1+1)
 */
public class HighCardRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean allOne = true;
        if (rankCount.size() == Constants.HAND_CARD_NUMBERS) {
            List<Card> cards = player.getCards();
            if (!this.isSameSuit(cards)) {
                allOne = !this.isStraight(player);
            }
        }

        if (allOne) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.HIGH_CARD);
        }

        return result;
    }

}
