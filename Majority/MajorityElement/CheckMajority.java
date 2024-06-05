package Majority.MajorityElement;

// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/

public class CheckMajority {
    public boolean isMajorityElement(int[] nums, int target) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                count++;

            } else {

                if (count > 0) {
                    break;
                }
            }

        }

        return count > (nums.length / 2);
    }
}
