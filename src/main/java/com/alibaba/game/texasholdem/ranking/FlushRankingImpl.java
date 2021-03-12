package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.RankingEnum;

import java.util.List;

/**
 * Class {@code FlushRankingImpl}
 * 解析玩家手中的牌是不是同花(花色连续一样)
 *
 * @author fm035
 */
public class FlushRankingImpl extends AbstractRanking {

    @Override
    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        // 如果是同色
        if (this.isSameSuit(cards)) {
            if( !this.isStraight(player)){
                result = new RankingResult();
                result.setRankingEnum(RankingEnum.FLUSH);
            }
        }

        return result;
    }

}
