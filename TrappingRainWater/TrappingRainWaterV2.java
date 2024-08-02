package TrappingRainWater;

public class TrappingRainWaterV2 {

    public int trap(int[] height) {
        int length = height.length;

        int water = 0;

        int[] leftMax = new int[length];
        leftMax[0] = 0;

        int maxLeftSofar = height[0];

        for (int i = 1; i < length; i++) {
            leftMax[i] = maxLeftSofar;

            maxLeftSofar = Math.max(maxLeftSofar, height[i]);
        }

        int[] rightMax = new int[length];
        rightMax[length - 1] = 0;

        int maxRightSofar = height[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = maxRightSofar;

            maxRightSofar = Math.max(maxRightSofar, height[i]);
        }

        for (int i = 1; i < length - 1; i++) {
            int delta = Math.min(leftMax[i], rightMax[i]) - height[i];

            if (delta > 0) {
                water += delta;
            }

        }

        return water;
    }
}
