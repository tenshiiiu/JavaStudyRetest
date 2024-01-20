class Array2D {

    public static void main(String[] args) {

        int[][] arr = {
                {25, 95, 70},
                {55, 80, 65},
        };

        // Loop through each element of the 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                // Check if the sum of row index and column index is even
                if ((i + j) % 2 == 0) {
                    // If even, add 7 to the current element
                    arr[i][j] += 7;
                } else {
                    // If odd, divide the current element by 3
                    arr[i][j] /= 3;
                }
            }
        }

        // Print the modified array
        System.out.println("The modified array is :");
        displayArray2D(arr);

        // Find the largest number for each column
        int[] columnMaxArray = findColumnMax(arr);

        // Print the largest numbers for each column
        System.out.println("\nThe largest number for each column is:");
        displayArray1D(columnMaxArray);
    }

    // Display the 2D array
    public static void displayArray2D(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                // Print each element of the array followed by a space
                System.out.print(A[i][j] + " ");
            }
            // Move to the next line after printing all elements in a row
            System.out.println();
        }
    }

    // Display the 1D array
    public static void displayArray1D(int[] A) {
        for (int i = 0; i < A.length; i++) {
            // Print each element of the array followed by a space
            System.out.print(A[i] + " ");
        }
        // Move to the next line after printing all elements
        System.out.println();
    }

    // Find the largest number for each column in the 2D array
    public static int[] findColumnMax(int[][] A) {
        int[] columnMaxArray = new int[A[0].length];

        for (int j = 0; j < A[0].length; j++) {
            int max = A[0][j];

            for (int i = 1; i < A.length; i++) {
                // Compare and update the maximum value for the column
                if (A[i][j] > max) {
                    max = A[i][j];
                }
            }

            // Store the maximum value for the column in the result array
            columnMaxArray[j] = max;
        }

        return columnMaxArray;
    }
}
