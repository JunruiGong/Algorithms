package LeetCode;

import org.junit.Test;

/**
 * Leetcode-294-Flip Game II
 *
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class FlipGameII {

    public boolean canWin(String s) {

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            if (c[i] == '+' && c[i + 1] == '+') {

                // 自己先翻转一次
                c[i] = '-';
                c[i + 1] = '-';

                // 对手再翻转一次
                boolean opponentWin = canWin(new String(c));

                c[i] = '+';
                c[i + 1] = '+';

                // 如果对手翻转之后返回false，则说明自己是可以赢的
                if (!opponentWin) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public  void Test(){

        String s = "++++";
        System.out.println(canWin(s));

    }
}
