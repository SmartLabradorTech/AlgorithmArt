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

        for (int i = 0; i < people.length; i++) {

            int emptyPositions = 0;

            for (int k = 0; k < people.length; k++) {
                if (result[k] == null) {
                    emptyPositions++;
                }

                if (emptyPositions == people[i][1] + 1) {
                    // we find it.
                    result[k] = people[i];
                    break;
                }

            }
        }

        return result;
    }

    public void print(int[][] people) {
        System.out.println("print");

        for (int i = 0; i < people.length; i++) {
            System.out.println(Arrays.toString(people[i]));
        }
    }

    public static void main(String[] args) {

        QueueReconstruction qs = new QueueReconstruction();
        int[][] test = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

        qs.print(qs.reconstructQueue(test));
    }
}
