package array.jumpgame;

import java.util.HashSet;
import java.util.Set;

public class JumpGameIII {

    // https://leetcode.com/problems/jump-game-iii/

    public boolean canReach(int[] arr, int start) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {

                Set<Integer> visited = new HashSet<>();

                boolean reach = canReachFrom(arr, start, i, visited);

                if (reach) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canReachFrom(int[] arr, int start, int end, Set<Integer> visited) {
        if (start < 0 || start >= arr.length) {
            return false;
        }

        if (start == end) {
            return true;
        }

        if (visited.contains(start)) {
            return false;
        }

        int left = start - arr[start];

        int right = start + arr[start];

        visited.add(start);

        boolean leftReach = canReachFrom(arr, left, end, visited);

        if (leftReach) {
            return true;
        }

        boolean rightReach = canReachFrom(arr, right, end, visited);
        if (rightReach) {
            return true;
        }

        visited.remove(start);

        return false;
    }

    public static void main(String[] args) {

        JumpGameIII jj = new JumpGameIII();

        // int[] arr = { 4, 2, 3, 0, 3, 1, 2 };

        int[] arr = { 3, 0, 2, 1, 2 };

        // int start = 5;

        int start = 2;

        System.out.println(jj.canReach(arr, start));
    }
}
