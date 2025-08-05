package CompetitiveCoding;

public class MaxHourGlass {
    // Function to calculate the maximum hourglass sum in the matrix
    public static int maxHourglassSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int maxSum = Integer.MIN_VALUE;

        // Loop to consider each possible hourglass center
 
for (int i = 0; i <= rows - 3; i++) {
    for (int j = 0; j <= cols - 3; j++) {
        int currentSum = 
            arr[i][j]     + arr[i][j+1]     + arr[i][j+2]
                         + arr[i+1][j+1] +
            arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
        if (currentSum > maxSum) {
            maxSum = currentSum;
        }
    }
}

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arr = {
            { 1, 1, 1, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0 },
            { 0, 0, 2, 4, 4, 0 },
            { 0, 0, 0, 2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };
        System.out.println("Maximum Hourglass Sum: " + maxHourglassSum(arr));
    }
}

