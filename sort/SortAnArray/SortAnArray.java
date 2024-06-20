package sort.SortAnArray;

import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/description/

public class SortAnArray {
    public int[] sortArray(int[] nums) {

        sort(nums, 0, nums.length - 1);

        return nums;
    }

    private void sort(int[] nums, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(nums, start, mid);

        sort(nums, mid + 1, end);

        // perform merge
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int next = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[next] = nums[i];
                next++;
                i++;
            } else {
                temp[next] = nums[j];
                j++;
                next++;

            }
        }

        while (i <= mid) {
            temp[next] = nums[i];
            i++;
            next++;
        }

        while (j <= end) {
            temp[next] = nums[j];
            j++;
            next++;
        }

        for (int k = 0; k < temp.length; k++) {
            nums[start + k] = temp[k];
        }
    }

    public static void main(String[] args) {

        SortAnArray sa = new SortAnArray();

        int[] nums = { -2, 3, -5 };

        System.out.println(Arrays.toString(sa.sortArray(nums)));

    }
}
