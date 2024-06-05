class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int currentNumber = nums[0];
        int startIndex = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == currentNumber) {
                continue;
            }

            // find a new number
            startIndex++;
            nums[startIndex] = nums[i];
            currentNumber = nums[i];

        }

        return startIndex + 1;
    }

    public static void main(String[] args) {

        RemoveDuplicates rd = new RemoveDuplicates();

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        System.out.println(rd.removeDuplicates(nums));

    }

}