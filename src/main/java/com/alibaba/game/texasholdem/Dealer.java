package com.alibaba.game.texasholdem;

import com.alibaba.game.texasholdem.ranking.RankingFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class {@code Dealer} 荷官, 负责发牌, 启动游戏.
 *
 * @author fm035
 */
public class Dealer {

    private final Poker poker;
    private final List<Player> playerList;

    public Dealer() {
        this.poker = new Poker();
        this.playerList = new ArrayList<>();
    }

    public Dealer(Player top, Player... players) {
        this();
        this.playerList.add(top);
        this.playerList.addAll(Arrays.asList(players));
    }

    /**
     * 新增玩家
     *
     * @param player
     */
    public void join(Player player) {
        this.playerList.add(player);
    }

    /**
     * 获得玩家数量
     *
     * @return
     */
    public int getPlayerSize() {
        return this.playerList.size();
    }

    /**
     * 开始游戏, 负责被每个玩家发牌
     */
    public void start() {
        for (Player player : this.playerList) {
            int nextInt = Constants.HAND_CARD_NUMBERS;
            for (int j = 0; j < nextInt; j++) {
                player.addCard(this.poker.dispatch());
            }
        }
    }

    /**
     * 发底牌 / 窩牌  數量
     */
    private static final int HOLE_CARD_NUM = 2;

    /**
     * 发底牌 / 窩牌
     */
    public void holeCards() {
        for (Player player : this.playerList) {
            if (TexasPlayerStatusEnum.FOLD != player.getStatus()) {
                for (int j = 0; j < HOLE_CARD_NUM; j++) {
                    player.addCard(this.poker.dispatch());
                }
            }
        }
    }

    /**
     * 懸牌 / 轉牌 / 河牌
     */
    public void deal() {
        Card card = this.poker.dispatch();
        for (Player player : this.playerList) {
            if (TexasPlayerStatusEnum.FOLD != player.getStatus()) {
                player.addCard(card);
            }
        }
    }

    /**
     * 计算每个玩家的牌型
     */
    public void showHand() {
        for (Player player : this.playerList) {
            RankingFacade.getInstance().resolve(player);
        }
    }

    public List<Player> getRankingPlayers() {
        Collections.sort(this.playerList);
        return this.playerList;
    }
}
