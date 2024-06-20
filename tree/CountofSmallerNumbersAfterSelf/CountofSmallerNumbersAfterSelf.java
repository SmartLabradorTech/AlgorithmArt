package tree.CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    count++;
                }
            }

            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {

        CountofSmallerNumbersAfterSelf cs = new CountofSmallerNumbersAfterSelf();

        int[] nums = { 5, 2, 6, 1 };

        System.out.println(cs.countSmaller(nums));

    }

}
