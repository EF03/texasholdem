package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.CardSuitEnum;
import com.alibaba.game.texasholdem.Constants;
import com.alibaba.game.texasholdem.Player;

import java.util.*;

/**
 * Class {@code AbstractRanking} 抽象牌型解析接口, 抽象解析流程
 *
 * @author fm035
 */
public abstract class AbstractRanking implements IRanking {

    @Override
    public RankingResult resolve(Player player) {
        this.preResolve(player);
        RankingResult result = this.doResolve(player);
        this.postResolve(player, result);
        return result;
    }

    private void preResolve(Player player) {
        Collections.sort(player.getCards());
    }

    private void postResolve(Player player, RankingResult result) {
        if (result != null) {
            result.setHighCard((player.getCards().get(0)));
        }
        player.setRankingResult(result);
    }

    /**
     * 牌型解析接口的返回值
     *
     * @param player 玩家
     * @return RankingResult 返回结果
     */
    protected abstract RankingResult doResolve(Player player);

    protected boolean isSameSuit(List<Card> cards) {
        if (cards == null || cards.size() == 0) {
            return false;
        }
        if (cards.size() < 5) {
            return false;
        }
        Map<CardSuitEnum, Integer> map = new HashMap<>(4);
        int maxFlower = 0;
        int tempFlower;
        for (Card card : cards) {
            CardSuitEnum suitEnum = card.getSuit();
            tempFlower = map.get(suitEnum) == null ? 0 : map.get(suitEnum);
            ++tempFlower;
            map.put(suitEnum, tempFlower);
            if (tempFlower > maxFlower) {
                maxFlower = tempFlower;
            }
        }
        return maxFlower >= Constants.COMPARE_CARD_NUMBERS;
    }


    protected boolean isStraight(Player player) {
        List<Card> cards = player.getCards();
        if (cards == null || cards.size() == 0) {
            return false;
        }
        if (cards.size() < 5) {
            return false;
        }
        Map<Integer, Integer> cardsRankCountMap = player.getCardsRankCountMap();
        List<Integer> sortedList = new ArrayList<>(cardsRankCountMap.keySet());
        boolean isStraight = false;
        int countToFour = 0;
        int preValue = 0;
        sortedList.sort(Collections.reverseOrder());
        for (int sortValue : sortedList) {
            if (preValue != 0 && sortValue - preValue == -1) {
                countToFour++;
            } else {
                countToFour = 0;
            }
            if (countToFour >= 4) {
                isStraight = true;
                break;
            }
            preValue = sortValue;
        }
        return isStraight;
    }
}
