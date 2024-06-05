package RotateArray;

import java.util.Arrays;

public class RotateArray {

    // https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if (k == 0) {
            return;
        }

        int totalMoves = 0;

        for (int i = 0; i < k; i++) {
            int sourceIndex = k + i;
            int sourceNum = nums[sourceIndex];

            nums[sourceIndex] = nums[i];

            totalMoves++;

            while (sourceIndex != i) {
                int targetIndex = (sourceIndex + k) % nums.length;

                int temp = nums[targetIndex];

                nums[targetIndex] = sourceNum;

                sourceIndex = targetIndex;
                sourceNum = temp;

                totalMoves++;
            }

            if (totalMoves == nums.length) {
                break;
            }

        }

    }

    public static void main(String[] args) {

        RotateArray ra = new RotateArray();

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        int k = 3;

        ra.rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }

}
