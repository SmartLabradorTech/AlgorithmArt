package array.jumpgame;

import java.util.Arrays;

public class JumpGameII {

    // https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
    public int jump(int[] nums) {

        int length = nums.length;

        int[] mins = new int[length];

        Arrays.fill(mins, 1, length, Integer.MAX_VALUE);

        for (int i = 1; i < length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] + j >= i) {
                    mins[i] = Math.min(mins[i], mins[j] + 1);
                }

            }

        }

        return mins[length - 1];
    }

    public static void main(String[] args) {

        JumpGameII jg = new JumpGameII();

        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(jg.jump(nums));
    }
}
