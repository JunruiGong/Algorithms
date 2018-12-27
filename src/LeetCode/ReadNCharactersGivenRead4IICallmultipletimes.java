package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode-158-Read N Characters Given Read4 II - Call multiple times
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *
 * Note:
 * The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4IICallmultipletimes {


    Queue<Character> queue = new LinkedList<>();

    public int read(char[] buf, int n) {

        int index = 0;

        // 将上一次调用剩余的字符存入buf中
        while (!queue.isEmpty() && index < n) {
            buf[index++] = queue.poll();
        }

        if (index == n) {
            return index;
        }

        char[] r4 = new char[4];
        while (index < n) {
            int c = read4(r4);

            int i = 0;
            for (; i < c && index < n; i++) {
                buf[index++] = r4[i];
            }

            // 如果index > n, 则将剩余的字符存入queue中
            while (i < c) {
                queue.offer(r4[i++]);
            }

            if (c < 4) {
                break;
            }
        }

        return index;

    }

    private int read4(char[] temp) {
        return 0;
    }

}
