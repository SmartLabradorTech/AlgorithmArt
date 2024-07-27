package ProductofArrayExceptSelf;

public class ProductofArrayExceptSelfV3 {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] result = new int[length];

        int leftSoFar = 1;

        for (int i = 0; i < length; i++) {
            result[i] = leftSoFar;
            leftSoFar *= nums[i];
        }

        int rightSoFar = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= rightSoFar;

            rightSoFar *= nums[i];
        }

        return result;
    }

}
