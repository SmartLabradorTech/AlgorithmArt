package tree.QueueReconstruction;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/queue-reconstruction-by-height/description/

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        boolean[] hasValue = new boolean[people.length];

        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }

        });

        for (int i = 0; i < people.length; i++) {

            int emptyPositions = 0;

            for (int k = 0; k < people.length; k++) {
                if (!hasValue[k] || result[k][0] == people[i][0]) {
                    emptyPositions++;
                }

                if (emptyPositions == people[i][1] + 1) {
                    // we find it.

                    result[k][0] = people[i][0];
                    result[k][1] = people[i][1];

                    hasValue[k] = true;

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
