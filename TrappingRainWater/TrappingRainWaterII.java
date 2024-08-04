package TrappingRainWater;

import java.util.Arrays;

// https://leetcode.com/problems/trapping-rain-water-ii/
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;

        int n = heightMap[0].length;

        int[][] horizontal = new int[m][n];

        for (int i = 0; i < m; i++) {

            int[] result = trap(heightMap[i]);

            horizontal[i] = result;
        }

        print(horizontal);

        int[][] vertical = new int[n][m];

        for (int j = 0; j < n; j++) {
            int[] tuple = new int[m];

            for (int s = 0; s < m; s++) {

                tuple[s] = heightMap[s][j];
            }

            int[] result = trap(tuple);

            vertical[j] = result;
        }

        print(vertical);

        int water = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                water += Math.min(horizontal[i][j], vertical[j][i]);

            }

        }

        return water;
    }

    public int[] trap(int[] nums) {
        int length = nums.length;

        int[] result = new int[length];

        int left = 0;

        int right = length - 1;

        int leftMax = 0;

        int rightMax = 0;

        while (left < right) {

            if (nums[left] < nums[right]) {
                leftMax = Math.max(leftMax, nums[left]);
                result[left] = leftMax - nums[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, nums[right]);
                result[right] = rightMax - nums[right];
                right--;
            }

        }

        return result;
    }

    private void print(int[][] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

    }

    public static void main(String[] args) {

        TrappingRainWaterII tr = new TrappingRainWaterII();

        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int[] temp = tr.trap(nums);

        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
        }

        System.out.println(sum);

        // int[][] map = {

        // { 1, 4, 3, 1, 3, 2 },
        // { 3, 2, 1, 3, 2, 4 },
        // { 2, 3, 3, 2, 3, 1 }
        // };

        int[][] map = {
                { 12, 13, 1, 12 },
                { 13, 4, 13, 12 },
                { 13, 8, 10, 12 },
                { 12, 13, 12, 12 },
                { 13, 13, 13, 13 }
        };

        // int[][] map = {
        // { 2, 3, 7 },
        // { 5, 1, 6 },
        // { 2, 4, 9 }

        // };

        System.out.println(tr.trapRainWater(map));

    }
}
