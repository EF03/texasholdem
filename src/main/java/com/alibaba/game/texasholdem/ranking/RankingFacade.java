package com.alibaba.game.texasholdem.ranking;

import com.alibaba.game.texasholdem.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code RankingFacade}
 * 牌型校验统一入口
 *
 * @author fm035
 */
public class RankingFacade implements IRanking {

    private final static List<IRanking> RANKINGS = new ArrayList<>();
    private static RankingFacade instance = null;
    private final static Object LOCK = new Object();

    static {
        RANKINGS.add(new RoyalFlushRankingImpl());
        RANKINGS.add(new StraightFlushRankingImpl());
        RANKINGS.add(new FourOfTheKindRankingImpl());
        RANKINGS.add(new FullHouseRankingImpl());
        RANKINGS.add(new FlushRankingImpl());
        RANKINGS.add(new StraightRankingImpl());
        RANKINGS.add(new ThreeOfTheKindRankingImpl());
        RANKINGS.add(new TwoPairsRankingImpl());
        RANKINGS.add(new OnePairRankingImpl());
        RANKINGS.add(new HighCardRankingImpl());
        RANKINGS.add(new DefaultRankingImpl());
    }

    private RankingFacade() {
    }

    /**
     * 單例模式 確定 init 不會重複執行
     */
    public static RankingFacade getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new RankingFacade();
                }
            }
        }
        return instance;
    }

    @Override
    public RankingResult resolve(Player player) {
        RankingResult result;
        for (IRanking ranking : RankingFacade.RANKINGS) {
            result = ranking.resolve(player);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

}
