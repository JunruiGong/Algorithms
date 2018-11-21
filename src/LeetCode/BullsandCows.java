package LeetCode;

import org.junit.Test;

/**
 * Leetcode-299-Bulls and Cows
 * <p>
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that
 * indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 */

public class BullsandCows {
    public String getHint(String secret, String guess) {

        if (secret == null) {
            return "0A0B";
        }

        int[] temp = new int[10];

        int A = 0;
        int B = 0;

        // 第一遍 如果相同位置上数字也相同，则A++
        // 如果不相同，就记录该数字的个数
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                temp[secret.charAt(i) - '0']++;
            }
        }


        // 第二遍 查找数字相同，但是位于不同的位置的数字
        for (int i = 0; i < secret.length(); i++) {

            // 如果两个数不相同，则判断guess的数字在不在temp中，如果存在，则B++
            if (secret.charAt(i) != guess.charAt(i) && temp[guess.charAt(i) - '0'] > 0) {
                temp[guess.charAt(i) - '0']--;
                B++;
            }
        }

        return A + "A" + B + "B";
    }

    @Test
    public void Test() {

        String secret = "1235";
        String guess = "1243";

        System.out.println(getHint(secret, guess));

    }
}
