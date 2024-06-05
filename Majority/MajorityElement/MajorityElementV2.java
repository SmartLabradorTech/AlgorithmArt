package Majority.MajorityElement;

public class MajorityElementV2 {

    public int majorityElement(int[] nums) {

        Integer leader = null;
        int vote = 0;

        for (int i = 0; i < nums.length; i++) {

            if (vote == 0) {
                leader = nums[i];
                vote++;
            } else {

                if (nums[i] == leader) {
                    vote++;
                } else {

                    vote--;
                }

            }

        }

        return leader;

    }

    public static void main(String[] args) {

        MajorityElementV2 me = new MajorityElementV2();

        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println(me.majorityElement(nums));
    }
}
