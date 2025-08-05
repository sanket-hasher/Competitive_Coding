package CompetitiveCoding;
public class SpiralMatrixNoCollections {
    public static void spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                System.out.print(matrix[top][col] + " ");
            }
            top++;

            // Traverse down the right column
            for (int row = top; row <= bottom; row++) {
                System.out.print(matrix[row][right] + " ");
            }
            right--;

            // Traverse from right to left, if there are remaining rows
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(matrix[bottom][col] + " ");
                }
                bottom--;
            }

            // Traverse from bottom to top, if there are remaining columns
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(matrix[row][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
        };
        spiralOrder(matrix);
        // Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
    }
}
