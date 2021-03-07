package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;

/**
 * Interface {@code IRanking} 牌型解析接口, 负责解析玩家手中的牌处于什么牌型
 *
 * @author fm035
 */
public interface IRanking {
    /**
     * 解析玩家手中的牌处于什么牌型
     *
     * @param player 牌桌內的玩家物件
     * @return 返回排型結果
     */
    RankingResult resolve(Player player);
}
