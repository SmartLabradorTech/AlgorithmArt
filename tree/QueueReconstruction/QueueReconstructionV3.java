package tree.QueueReconstruction;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/queue-reconstruction-by-height/description/

// for same height, make them descending by count.

public class QueueReconstructionV3 {

    class Bit {

        private int[] data;

        Bit(int n) {
            this.data = new int[n];
        }

        private int lowbit(int i) {
            return i & (-i);
        }

        public void add(int index, int delta) {

            for (int i = index + 1; i <= this.data.length; i += lowbit(i)) {
                data[i - 1] += delta;
            }
        }

        public int presum(int index) {

            int sum = 0;
            for (int i = index + 1; i > 0; i -= lowbit(i)) {
                sum += this.data[i - 1];
            }
            return sum;
        }

    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];

        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }

        });

        Bit bits = new Bit(people.length);

        for (int i = 0; i < people.length; i++) {

            // int location = find(0, people.length - 1, bits, i, result, people);

            int left = 0, right = people.length - 1;
            int mid = 0;

            while (left <= right) {

                mid = (left + right) / 2;

                int currentSpaces = mid + 1 - bits.presum(mid);

                if (currentSpaces < people[i][1] + 1) {
                    left = mid + 1;
                } else if (currentSpaces > people[i][1] + 1) {
                    right = mid - 1;
                } else {
                    // we find the exact spaces. but the current location could have been occupied.

                    if (result[mid] == null) {
                        break;
                    }

                    right = mid - 1;

                }
            }

            result[mid] = people[i];

            bits.add(mid, 1);
        }

        return result;
    }

    // public int find(int start, int end, Bit bits, int target, int[][] result,
    // int[][] people) {

    // if (start == end) {
    // return start;
    // }

    // int mid = (start + end) / 2;

    // int countOfOccupants = bits.presum(mid);

    // if (mid - countOfOccupants < people[target][1]) {
    // return find(mid + 1, end, bits, target, result, people);
    // } else {
    // return find(start, mid, bits, target, result, people);
    // }

    // }

    public void print(int[][] people) {
        System.out.println("print");

        for (int i = 0; i < people.length; i++) {
            System.out.println(Arrays.toString(people[i]));
        }
    }

    public static void main(String[] args) {

        QueueReconstructionV3 qs = new QueueReconstructionV3();
        int[][] test = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        qs.print(qs.reconstructQueue(test));
    }
}
