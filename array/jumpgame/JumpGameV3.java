package array.jumpgame;

/**
 * JumpGame
 */
public class JumpGameV3 {
    // https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

    public boolean canJump(int[] nums) {

        int length = nums.length;

        int rightMost = nums[0];

        for (int i = 1; i < length; i++) {

            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
            } else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame jGame = new JumpGame();

        // int[] nums = { 2, 3, 1, 1, 4 };

        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(jGame.canJump(nums));

    }

}