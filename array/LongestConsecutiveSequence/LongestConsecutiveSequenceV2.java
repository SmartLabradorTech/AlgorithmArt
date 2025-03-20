package array.LongestConsecutiveSequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequenceV2 {
    public int longestConsecutive(int[] nums) {

        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            unique.add(nums[i]);
        }

        List<Integer> updatedNums = new ArrayList<>(unique);

        int longest = 0;

        for (int i = 0; i < updatedNums.size(); i++) {

            int number = updatedNums.get(i);

            if (unique.contains(number - 1)) {
                // no need to use as start point
            } else {

                int currentLongest = 1;

                while (unique.contains(number + 1)) {
                    number++;
                    currentLongest++;
                }

                longest = Math.max(currentLongest, longest);

            }

        }

        return longest;
    }

    public static void main(String[] args) {

        LongestConsecutiveSequenceV2 le = new LongestConsecutiveSequenceV2();
        int[] nums = { 1, 0, 1, 2 };

        System.out.println(le.longestConsecutive(nums));

    }
}
