package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.RankingEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fm035
 */
public class ComparingFacade {

    private final static Map<RankingEnum, IComparing> MAPS = new HashMap<>(16);
    private final static IComparing DEFAULT_COMPARING = new DefaultComparingImpl();

    static {
        MAPS.put(RankingEnum.ROYAL_FLUSH, new RoyalFlushComparingImpl());
        MAPS.put(RankingEnum.STRAIGHT_FLUSH, new StraightFlushComparingImpl());
        MAPS.put(RankingEnum.FOUR_OF_THE_KIND, new FourOfTheKindComparingImpl());
        MAPS.put(RankingEnum.FULL_HOUSE, new FullHouseComparingImpl());
        MAPS.put(RankingEnum.FLUSH, new FlushComparingImpl());
        MAPS.put(RankingEnum.STRAIGHT, new StraightComparingImpl());
        MAPS.put(RankingEnum.THREE_OF_THE_KIND, new ThreeOfTheKindComparingImpl());
        MAPS.put(RankingEnum.TWO_PAIR, new TwoPairsComparingImpl());
        MAPS.put(RankingEnum.ONE_PAIR, new OnePairComparingImpl());
        MAPS.put(RankingEnum.HIGH_CARD, new HighCardComparingImpl());
    }

    public static IComparing getComparing(RankingEnum rankingEnum) {
        IComparing cmp = MAPS.get(rankingEnum);
        if (cmp == null) {
            return DEFAULT_COMPARING;
        } else {
            return cmp;
        }
    }

}
