package com.alibaba.game.texasholdem.comparing;

import com.alibaba.game.texasholdem.Card;
import com.alibaba.game.texasholdem.Player;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fm035
 */
public abstract class AbstractComparing implements IComparing {

    /**
     * 按照三条或者或者四条的比较
     *
     * @param map1
     * @param map2
     * @param pair 兩條 = 2 ,三條 = 3
     * @return
     */
    protected int multiComparing(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int pair) {

        AtomicInteger p1Number = new AtomicInteger(-1);
        AtomicInteger p2Number = new AtomicInteger(-1);

        map1.forEach((u, v) -> {
            if (v == pair && u > p1Number.get()) {
                p1Number.set(u);
            }
        });

        map2.forEach((u, v) -> {
            if (v == pair && u > p2Number.get()) {
                p2Number.set(u);
            }
        });

        return Integer.compare(p2Number.get(), p1Number.get());
    }

    /**
     * 按照顺序的比较
     *
     * @param p1
     * @param p2
     * @return
     */
    protected int seqComparing(Player p1, Player p2) {
        List<Card> p1Cards = p1.getCards();
        List<Card> p2Cards = p2.getCards();
        int size = p1.getCardSize();

        for (int i = 0; i < size; i++) {
            if (p1Cards.get(i).getRank().getNumber().equals(p2Cards.get(i).getRank().getNumber())) {
                continue;
            }
            if (p1Cards.get(i).getRank().getNumber() < p2Cards.get(i).getRank().getNumber()) {
                return 1;
            }
            if (p1Cards.get(i).getRank().getNumber() > p2Cards.get(i).getRank().getNumber()) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * @param map1
     * @param map2
     * @param pair              对子的数量 牌的匹配數量
     * @param maxPairLoopAddOne 对子最大的循环数量+1
     * @return
     */
    protected int pairComparing(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int pair, int maxPairLoopAddOne, int countNum) {
//        System.out.println("map1 size = " + map1.size());
//        System.out.println("map2 size = " + map2.size());
//        System.out.println("map1 = " + map1);
//        System.out.println("map2 = " + map2);
//        System.out.println("pair = " + pair);
//        System.out.println("maxPairLoopAddOne = " + maxPairLoopAddOne);
//        System.out.println("countNum = " + countNum);
        if (maxPairLoopAddOne - 1 == 0) {
            pair = 1;
        }
        int p1MaxNum = this.findMaxNumber(map1, pair);
        int p2MaxNum = this.findMaxNumber(map2, pair);
//        System.out.println("p1MaxNum = " + p1MaxNum);
//        System.out.println("p2MaxNum = " + p2MaxNum);
//        System.out.println("\n ============================================================ ");


        if (p1MaxNum < p2MaxNum) {
            return 1;
        }
        if (p1MaxNum > p2MaxNum) {
            return -1;
        }
        int removeNum = map1.remove(p1MaxNum);
        map2.remove(p2MaxNum);
        countNum -= removeNum;
        if (countNum == 0 && 0 >= maxPairLoopAddOne - 1) {
            return 0;
        }
        return this.pairComparing(map1, map2, pair, maxPairLoopAddOne - 1, countNum);
    }

    private int findMaxNumber(Map<Integer, Integer> map, int pair) {
        AtomicInteger p1Number = new AtomicInteger(-1);
        map.forEach((k, v) -> {
            if (v == pair) {
                int number = k;
                if (number > p1Number.get()) {
                    p1Number.set(number);
                }
            }
        });
        return p1Number.get();

    }

}
