package array.jumpgame;

/**
 * JumpGame
 */
public class JumpGameV2 {
    // https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

    public boolean canJump(int[] nums) {

        int length = nums.length;

        int leftMostValid = length - 1;

        for (int i = length - 2; i >= 0; i--) {

            if (nums[i] + i >= leftMostValid) {
                leftMostValid = i;
            }
        }

        return leftMostValid == 0;
    }

    public static void main(String[] args) {
        JumpGame jGame = new JumpGame();

        int[] nums = { 2, 3, 1, 1, 4 };

        // int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(jGame.canJump(nums));

    }

}