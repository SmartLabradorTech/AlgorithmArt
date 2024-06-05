class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {

        int nextIndex = 1;

        int occur = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {

                occur++;

                if (occur < 3) {
                    nums[nextIndex] = nums[i];
                    nextIndex++;
                }
            } else {

                // find a new number

                occur = 1;

                nums[nextIndex] = nums[i];
                nextIndex++;

            }

        }

        return nextIndex;

    }

    public static void main(String[] args) {

        RemoveDuplicatesII rd = new RemoveDuplicatesII();

        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

        System.out.println(rd.removeDuplicates(nums));

    }

}