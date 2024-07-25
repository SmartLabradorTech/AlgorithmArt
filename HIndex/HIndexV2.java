package HIndex;

import java.util.Arrays;

public class HIndexV2 {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int length = citations.length;

        for (int i = length; i > 0; i--) {
            int index = find(citations, 0, length - 1, i);

            if (length - 1 - index >= i) {
                return i;
            }

        }

        return 0;
    }

    // find the last small number than target
    private int find(int[] nums, int left, int right, int target) {

        if (target > nums[right]) {
            return right;
        }

        if (target <= nums[left]) {
            return left - 1;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {

            return find(nums, left, mid - 1, target);

        } else if (target < nums[mid]) {
            return find(nums, left, mid - 1, target);
        } else {
            return find(nums, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {

        HIndexV2 hi = new HIndexV2();

        int[] nums = { 2, 1, 1, 1 };

        System.out.println(hi.hIndex(nums));

    }
}
