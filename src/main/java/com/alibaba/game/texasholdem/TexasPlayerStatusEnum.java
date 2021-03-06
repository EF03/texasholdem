package com.alibaba.game.texasholdem;

public enum TexasPlayerStatusEnum {
    /* 蓋牌 / 棄牌 */
    FOLD("0"),
    /* 全下 / 全進 */
    All_in("1"),
    ;

    private String status;

    public String getStatus() {
        return this.status;
    }

    TexasPlayerStatusEnum(String status) {
        this.status = status;
    }
}
