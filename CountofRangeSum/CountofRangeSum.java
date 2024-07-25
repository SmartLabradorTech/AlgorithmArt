package CountofRangeSum;

// https://leetcode.com/problems/count-of-range-sum/description/

public class CountofRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int count = 0;

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            long sum = 0;

            for (int j = i; j < length; j++) {

                sum += nums[j];

                if (sum >= lower && sum <= upper) {
                    count++;

                }
            }

        }

        return count;
    }

    public static void main(String[] args) {

        CountofRangeSum cs = new CountofRangeSum();

        System.out.println(cs.countRangeSum(null, 0, 0));
    }

}
