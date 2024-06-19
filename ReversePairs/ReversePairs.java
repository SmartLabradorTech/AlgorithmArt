package ReversePairs;

// https://leetcode.com/problems/reverse-pairs/

class ReversePairs {

    public int reversePairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > 2.0 * nums[j]) {
                    count++;
                }

            }

        }

        return count;
    }

    public static void main(String[] args) {

        ReversePairs rp = new ReversePairs();

        int[] nums = { 1, 3, 2, 3, 1 };

        System.out.println(rp.reversePairs(nums));

    }
}