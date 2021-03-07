package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Player;

/**
 * Class {@code HighCardComparingImpl}
 * 高牌的大小比较(按顺序比较)
 * @author fm035
 */
public class HighCardComparingImpl extends AbstractComparing {

    @Override
    public int compare(Player o1, Player o2) {
        return this.seqComparing(o1, o2);
    }

}
