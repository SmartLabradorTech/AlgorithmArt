package TrappingRainWater;

// official answer. for analysis only.

public class TrappingRainWaterV3 {

    public int trap(int[] height) {

        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                ++left;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        TrappingRainWaterV3 tr = new TrappingRainWaterV3();

        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(tr.trap(nums));
    }
}
