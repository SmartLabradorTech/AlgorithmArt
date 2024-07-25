package HIndex;

public class HIndexV4 {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] count = new int[length + 1];

        for (int i = 0; i < length; i++) {
            count[Math.min(length, citations[i])]++;
        }

        int citationSoFar = 0;

        for (int i = length; i >= 0; i--) {

            citationSoFar += count[i];

            if (citationSoFar >= i) {
                return i;
            }

        }

        return 0;
    }
}
