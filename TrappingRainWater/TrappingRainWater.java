package TrappingRainWater;

// https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150

public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;

        int water = 0;

        for (int i = 1; i < length - 1; i++) {

            // how much it can hold at its index?

            int maxLeft = find(height, 0, i - 1);

            int maxRight = find(height, i + 1, length - 1);

            int delta = Math.min(maxLeft, maxRight) - height[i];

            if (delta > 0) {
                water += delta;
            }

        }

        return water;
    }

    private int find(int[] nums, int i, int j) {

        int max = nums[i];

        for (int m = i + 1; m <= j; m++) {
            max = Math.max(max, nums[m]);
        }

        return max;
    }
}
