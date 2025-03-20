package array.LongestConsecutiveSequence;

import java.util.Arrays;

// https://leetcode.com/problems/longest-consecutive-sequence/description/

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestTillNow = 1;

        int longestEndingAtCurrent = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] == 1) {
                longestEndingAtCurrent++;

                longestTillNow = Math.max(longestEndingAtCurrent, longestTillNow);

            } else if (nums[i] == nums[i - 1]) {

            } else {
                longestEndingAtCurrent = 1;
            }

        }

        return longestTillNow;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequence ls = new LongestConsecutiveSequence();

        // int[] nums = { 100, 4, 200, 1, 3, 2 };

        int[] nums = { 1, 0, 1, 2 };

        System.out.println(ls.longestConsecutive(nums));
    }
}
