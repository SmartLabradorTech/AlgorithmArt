package array.jumpgame;

public class JumpGameIIV2 {

    // https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150

    public int jump(int[] nums) {

        int length = nums.length;

        int result = 0;

        int far = nums[0];

        int end = 0;

        while (end < length - 1) {
            int newFar = far;

            for (int i = end + 1; i <= far && i < length; i++) {
                newFar = Math.max(newFar, nums[i] + i);
            }

            end = far;

            far = newFar;

            result++;
        }

        return result;
    }

    public static void main(String[] args) {

        JumpGameIIV2 jj = new JumpGameIIV2();

        // int[] nums = { 2, 3, 1, 1, 4 };

        int[] nums = { 2, 3, 0, 1, 4 };

        System.out.println(jj.jump(nums));

    }

}
