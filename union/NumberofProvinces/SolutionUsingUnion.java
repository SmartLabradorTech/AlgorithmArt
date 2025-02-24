package union.NumberofProvinces;

// https://leetcode.com/problems/number-of-provinces/description/

public class SolutionUsingUnion {

    class UnionFind {

        private int[] capital;

        private int[] size;

        private int unionCount;

        private int n;

        public UnionFind(int[][] isConnected) {
            unionCount = 0;

            n = isConnected.length;
            capital = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                capital[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < n; i++) {

                for (int j = i + 1; j < n; j++) {

                    if (isConnected[i][j] == 1) {
                        union(i, j);
                    }

                }
            }

        }

        public void union(int x, int y) {

            int first = find(x);

            int second = find(y);

            if (first != second) {

                if (size[first] < size[second]) {
                    capital[first] = second;

                    size[second] += size[first];
                } else {
                    capital[second] = first;
                    size[first] += size[second];
                }

                unionCount++;
            }
        }

        public int find(int x) {

            if (capital[x] == x) {
                return x;
            }

            return find(capital[x]);
        }

        public int count() {
            return n - unionCount;
        }

    }

    public int findCircleNum(int[][] isConnected) {

        UnionFind uf = new UnionFind(isConnected);

        return uf.count();
    }
}
