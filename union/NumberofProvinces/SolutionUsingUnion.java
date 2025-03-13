package union.NumberofProvinces;

// https://leetcode.com/problems/number-of-provinces/description/
// using rank

public class SolutionUsingUnion {

    class UnionFind {

        private int[] capital;

        private int[] rank;

        private int unionCount;

        private int n;

        public UnionFind(int[][] isConnected) {
            unionCount = 0;

            n = isConnected.length;
            capital = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                capital[i] = i;
                rank[i] = 0;
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

                if (rank[first] == rank[second]) {
                    capital[second] = first;
                    rank[first]++;
                } else if (rank[first] < rank[second]) {
                    capital[first] = second;
                } else {
                    capital[second] = first;
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
