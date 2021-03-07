package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

/**
 * Class {@code StraightComparingImpl}
 * 顺子的大小比较(按顺序比较)
 * @author fm035
 */
public class StraightComparingImpl extends AbstractComparing {

    @Override
    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
