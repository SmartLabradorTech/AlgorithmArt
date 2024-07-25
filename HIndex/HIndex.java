package HIndex;

// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150

public class HIndex {
    public int hIndex(int[] citations) {

        int length = citations.length;

        for (int i = length; i > 0; i--) {

            // check if i is valid

            int count = 0;
            for (int j = 0; j < length; j++) {

                if (citations[j] >= i) {
                    count++;
                }
            }

            if (count >= i) {
                return i;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();

        System.out.println(hIndex.hIndex(null));

    }
}
