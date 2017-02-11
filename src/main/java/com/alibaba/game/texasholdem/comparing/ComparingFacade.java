package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.RankingEnum;

import java.util.HashMap;
import java.util.Map;

public class ComparingFacade {

    private final static Map<RankingEnum, IComparing> maps = new HashMap<RankingEnum, IComparing>();

    static {
        maps.put(RankingEnum.ROYAL_FLUSH, new RoyalFlushComparingImpl());
        maps.put(RankingEnum.STRAIGHT_FLUSH, new StraightFlushComparingImpl());
        maps.put(RankingEnum.FOUR_OF_THE_KIND, new FourOfTheKindComparingImpl());
        maps.put(RankingEnum.FULL_HOUSE, new FullHouseComparingImpl());
        maps.put(RankingEnum.FLUSH, new FlushComparingImpl());
        maps.put(RankingEnum.STRAIGHT, new StraightComparingImpl());
        maps.put(RankingEnum.THREE_OF_THE_KIND, new ThreeOfTheKindComparingImpl());
        maps.put(RankingEnum.TWO_PAIR, new TwoPairsComparingImpl());
        maps.put(RankingEnum.ONE_PAIR, new OnePairComparingImpl());
    }

    public static IComparing getComparing(RankingEnum rankingEnum) {
        return maps.get(rankingEnum);
    }

}
