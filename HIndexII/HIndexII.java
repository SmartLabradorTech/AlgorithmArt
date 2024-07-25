package HIndexII;

/**
 * HIndexII
 */
public class HIndexII {

    // https://leetcode.com/problems/h-index-ii/description/

    public int hIndex(int[] citations) {

        return find(citations, 0, citations.length - 1);
    }

    private int find(int[] citations, int left, int right) {
        int mid = (left + right) / 2;

        int paperCount = citations.length - 1 - mid + 1;

        if (paperCount == citations[mid]) {
            return citations[mid];
        } else if (paperCount < citations[mid]) {
            if (left == mid) {
                return paperCount;
            }

            return Math.max(paperCount, find(citations, left, mid - 1));
        } else {
            if (mid == right) {
                return citations[left];
            }

            return Math.max(citations[mid], find(citations, mid + 1, right));
        }
    }

    public static void main(String[] args) {

        HIndexII hi = new HIndexII();

        int[] citations = { 1, 4, 7, 9 };

        System.out.println(hi.hIndex(citations));
    }
}