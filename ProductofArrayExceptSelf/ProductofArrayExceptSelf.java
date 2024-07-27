package ProductofArrayExceptSelf;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    // https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150

    public int[] productExceptSelf(int[] nums) {

        int product = 1;

        int countOfZero = 0;

        int[] result = new int[nums.length];

        Arrays.fill(result, 0);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                countOfZero++;
            } else {
                product *= nums[i];

            }

        }

        if (countOfZero > 1) {
            return result;
        } else if (countOfZero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = product;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;

    }

}
