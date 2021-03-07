package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

import java.util.Map;

/**
 * Class {@code ThreeOfTheKindComparingImpl}
 * 三条的大小比较(直接比较三条)
 * @author fm035
 */
public class ThreeOfTheKindComparingImpl extends AbstractComparing {

    @Override
    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getCardsRankCountMap();
        Map<Integer, Integer> p2CardMap = o2.getCardsRankCountMap();
        int compare = this.multiComparing(p1CardMap, p2CardMap, 3);
        if (compare == 0) {
            return this.seqComparing(o1, o2);
        }

        return compare;
    }

}
