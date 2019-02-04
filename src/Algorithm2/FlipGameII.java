package Algorithm2;

import java.util.Arrays;

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

        for (int i=1;i<c.length;i++){
            if(c[i]=='+'&&c[i-1]=='+'){
                c[i]=c[i-1]='-';

                boolean opponentWin = canWin(Arrays.toString(c));
                c[i]=c[i-1]='+';

                if (!opponentWin){
                    return true;
                }
            }
        }

        return false;
    }
}
