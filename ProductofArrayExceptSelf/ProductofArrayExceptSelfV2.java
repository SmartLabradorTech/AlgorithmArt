package ProductofArrayExceptSelf;

public class ProductofArrayExceptSelfV2 {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] fromLeft = new int[length];
        int[] fromRight = new int[length];

        int[] result = new int[length];

        int left = 1;
        int right = 1;

        for (int i = 0; i < length; i++) {
            left *= nums[i];

            fromLeft[i] = left;
        }

        for (int i = length - 1; i >= 0; i--) {

            right *= nums[i];

            fromRight[i] = right;
        }

        for (int i = 0; i < length; i++) {

            int leftSide = 1;

            if (i - 1 >= 0) {
                leftSide *= fromLeft[i - 1];
            }

            int rightSide = 1;

            if (i + 1 < length) {
                rightSide *= fromRight[i + 1];
            }

            result[i] = leftSide * rightSide;
        }

        return result;
    }

}
