package TrappingRainWater;

public class TrappingRainWaterV4 {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                leftMax = Math.max(leftMax, height[left]);

                water += leftMax - height[left];

                left++;
            } else {

                rightMax = Math.max(rightMax, height[right]);

                water += rightMax - height[right];

                right--;
            }
        }

        System.out.println(left);

        return water;
    }

    public static void main(String[] args) {

        TrappingRainWaterV4 tr = new TrappingRainWaterV4();

        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(tr.trap(nums));
    }
}
