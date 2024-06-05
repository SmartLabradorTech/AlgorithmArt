package Majority.MajorityElement;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        int maxCount = 0;
        int majority = -1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (count.containsKey(current)) {
                count.put(current, count.get(current) + 1);
            } else {
                count.put(current, 1);
            }

            if (count.get(current) > maxCount) {
                maxCount = count.get(current);
                majority = current;
            }
        }

        return majority;
    }

    public static void main(String[] args) {

        MajorityElement me = new MajorityElement();

        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println(me.majorityElement(nums));
    }
}
