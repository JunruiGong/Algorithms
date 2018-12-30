package LeetCode;

import org.junit.Test;

/**
 * Leetcode-165-Compare Version Numbers-Medium
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 *
 * Example 1:
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 *
 * Example 2:
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 *
 * Example 3:
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] level1 = version1.split("\\.");
        String[] level2 = version2.split("\\.");

        int length = Math.max(level1.length, level2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < level1.length ? Integer.parseInt(level1[i]) : 0;
            Integer v2 = i < level2.length ? Integer.parseInt(level2[i]) : 0;
            int compare = v1.compareTo(v2);

            // 如果不相等，直接返回结果
            // 如果相等，继续比较下一个
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    @Test
    public void test() {
        compareVersion("as", "as");

    }
}
