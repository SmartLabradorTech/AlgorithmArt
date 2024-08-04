package TrappingRainWater;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TrappingRainWaterIIV3 {

    class Cell {
        int row;
        int col;

        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public boolean equals(Object obj) {
            Cell itCell = (Cell) obj;
            return row == itCell.row && col == itCell.col;
        }

        @Override
        public int hashCode() {
            // Using Objects.hash() to generate hash code
            return Objects.hash(row, col);
        }

    }

    private int handleCell(Cell newCell, Cell smallCell, Set<Cell> visited, Queue<Cell> cells) {

        int addedWater = 0;

        if (!visited.contains(newCell)) {
            if (newCell.height < smallCell.height) {
                addedWater = smallCell.height - newCell.height;

                newCell.height = smallCell.height;

                visited.add(newCell);
                cells.add(newCell);

            } else {
                visited.add(newCell);
                cells.add(newCell);
            }
        }

        return addedWater;
    }

    public int trapRainWater(int[][] heightMap) {

        Comparator<Cell> stringLengthComparator = new Comparator<Cell>() {
            @Override
            public int compare(Cell s1, Cell s2) {
                // Compare strings based on their lengths
                return Integer.compare(s1.height, s2.height);
            }
        };

        Queue<Cell> cells = new PriorityQueue<>(stringLengthComparator);

        Set<Cell> visited = new HashSet<>();

        int rowCount = heightMap.length;

        int colCount = heightMap[0].length;

        for (int i = 0; i < colCount; i++) {
            Cell cell1 = new Cell(0, i, heightMap[0][i]);
            cells.add(cell1);
            visited.add(cell1);

            Cell cell2 = new Cell(rowCount - 1, i, heightMap[rowCount - 1][i]);
            cells.add(cell2);
            visited.add(cell2);

        }

        for (int j = 1; j <= rowCount - 2; j++) {
            Cell cell1 = new Cell(j, 0, heightMap[j][0]);
            cells.add(cell1);
            visited.add(cell1);

            Cell cell2 = new Cell(j, colCount - 1, heightMap[j][colCount - 1]);
            cells.add(cell2);
            visited.add(cell2);
        }

        int water = 0;

        while (!cells.isEmpty()) {

            Cell smallCell = cells.poll();

            // check left
            int leftCol = smallCell.col - 1;
            if (leftCol >= 0) {
                int leftRow = smallCell.row;
                Cell leftCell = new Cell(leftRow, leftCol, heightMap[leftRow][leftCol]);

                water += handleCell(leftCell, smallCell, visited, cells);
            }

            // check right
            int rightCol = smallCell.col + 1;

            if (rightCol < colCount) {

                int rightRow = smallCell.row;

                Cell rightCell = new Cell(rightRow, rightCol, heightMap[rightRow][rightCol]);

                water += handleCell(rightCell, smallCell, visited, cells);
            }

            // check upper
            int upperRow = smallCell.row - 1;

            if (upperRow >= 0) {
                int upperCol = smallCell.col;

                Cell upperCell = new Cell(upperRow, upperCol, heightMap[upperRow][upperCol]);

                water += handleCell(upperCell, smallCell, visited, cells);
            }

            // check down
            int downRow = smallCell.row + 1;

            if (downRow < rowCount) {
                int downCol = smallCell.col;

                Cell downCell = new Cell(downRow, downCol, heightMap[downRow][downCol]);

                water += handleCell(downCell, smallCell, visited, cells);
            }

        }

        return water;
    }

    public static void main(String[] args) {

        TrappingRainWaterIIV3 tr = new TrappingRainWaterIIV3();

        int[][] heightMap = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };

        System.out.println(tr.trapRainWater(heightMap));
    }
}
