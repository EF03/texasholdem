package com.alibaba.game;

import com.alibaba.game.texasholdem.Dealer;
import com.alibaba.game.texasholdem.Player;
import com.alibaba.game.texasholdem.TexasPlayerStatusEnum;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
     * Player{playerId=1, cards=[♠2, ♠9, ♦2, ♣2, ♥4], rankingResult=RankingResult{rankingEnum=三条}}
     * Player{playerId=2, cards=[♣6, ♥2, ♦2, ♣2, ♥4], rankingResult=RankingResult{rankingEnum=三条}}
     *
     * */

      /*
    同花顺＞铁支＞葫芦＞同花＞顺子＞三条＞两对＞对子＞散牌

    散牌：不符合其他任何规则的五张牌。 比较最大一张牌的大小，如果相同，比较第二大的牌的牌点数，如果五张牌的牌点数都相同，则为平局。
    对子：有两张同样大小的牌片。 比较两张大小一样的牌的牌点数，如果相同，依次比较剩余的三张牌大小。若大小都相同，则为平局。
    两对：有两个对子牌。 比较大对子的大小，若相同，比较小对子的大小，若还相同，比较单张牌的大小，若还相同，则为平局。
    三条：有三张同样大小的牌片。 比较三张大小一样的牌的牌点数大小。
    顺子：五张相连的牌。 比较最大的牌点数。若大小都相同，则为平局。
    同花：五张牌的花色相同。 按照散排规则比较大小。
    葫芦：三条+对子。 比较三张大小一样的牌的牌点数。
    铁支：有四张同样大小的牌片。 比较四张大小一样的牌的牌点数。
    同花顺：同一种花色的顺子。 比较最大的牌的牌的大小。若大小都相同，则为平局。 你的工作是为两手牌判断大小。
    例如： 输入: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH 输出: White wins - high card: Ace
    输入: Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S 输出: Black wins - full house
    输入: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C KH 输出: Black wins - high card: 9
    输入: Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH 输出: Tie
    */

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            boolean isBreak = playTexa();
//            if (isBreak) {
//                break;
//            }
        }
        System.out.println(System.currentTimeMillis() - time + " 毫秒");

    }

    private static boolean playTexa() {
        Dealer d = new Dealer();

        Player me = new Player();
        me.setPlayerId(1);
        Player you1 = new Player();
        you1.setPlayerId(2);
        Player you2 = new Player();
        you2.setPlayerId(3);
        Player you3 = new Player();
        you3.setPlayerId(4);

        d.join(me);
        d.join(you1);
        d.join(you2);
        d.join(you3);

//        d.start();
        d.holeCards();
//        d.getRankingPlayers().get(2).setStatus(TexasPlayerStatusEnum.FOLD);
        d.deal();
//        d.getRankingPlayers().get(3).setStatus(TexasPlayerStatusEnum.FOLD);
        d.deal();
//        d.getRankingPlayers().get(0).setStatus(TexasPlayerStatusEnum.FOLD);

        d.deal();
        d.deal();
        d.deal();

        d.showHand();


        List<Player> players = d.getRankingPlayers();

//        for (Player player : players) {
//            System.out.println(player.toString());
//        }

        List<Player> playerWithoutFoldList = players.stream().filter(e -> {
            return e.getStatus() != TexasPlayerStatusEnum.FOLD;
        }).collect(Collectors.toList());

        List<Integer> playerEvenList = getWinners(playerWithoutFoldList);

//        System.out.println(playerEvenList);
        return playerEvenList.size() > 1;
//        return true;
    }

    private static List<Integer> getWinners(List<Player> playerWithoutFoldList) {
        Player player1 = playerWithoutFoldList.get(0);
        List<Integer> playerEvenList = new LinkedList<>();
        playerEvenList.add(player1.getPlayerId());
        for (int i = 1; i < playerWithoutFoldList.size(); i++) {
            Player player2 = playerWithoutFoldList.get(i);
            int compareInt = player1.compareTo(player2);
            if (compareInt > 0) {
                player1 = player2;
                playerEvenList.clear();
                playerEvenList.add(player2.getPlayerId());
            } else if (compareInt == 0) {
                playerEvenList.add(player2.getPlayerId());
            }
        }
        return playerEvenList;
    }

    private static int compare(Player you1, Player you2) {
        int compareInt = you1.compareTo(you2);
        if (compareInt > 0) {
            return you2.getPlayerId();
        } else if (compareInt < 0) {
            return you1.getPlayerId();
        }
        return -1;
    }

}
