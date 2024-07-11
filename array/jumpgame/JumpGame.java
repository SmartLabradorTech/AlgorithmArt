package array.jumpgame;

/**
 * JumpGame
 */
public class JumpGame {
    // https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

    public boolean canJump(int[] nums) {

        int length = nums.length;

        boolean[] jump = new boolean[length];

        jump[0] = true;

        for (int i = 1; i < length; i++) {

            for (int j = 0; j < i; j++) {

                if (jump[j]) {

                    if (j + nums[j] >= i) {
                        jump[i] = true;
                        break;
                    }

                }

            }

        }

        return jump[length - 1];
    }

    public static void main(String[] args) {
        JumpGame jGame = new JumpGame();

        // int[] nums = { 2, 3, 1, 1, 4 };

        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(jGame.canJump(nums));

    }

}