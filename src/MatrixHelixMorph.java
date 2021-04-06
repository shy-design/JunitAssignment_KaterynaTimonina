public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */

    // author: Kateryna Timonina
    // for code creation I have reviewed the following references:
    // https://developpaper.com/spiral-matrix-i-ii-iii/
    //https://www.geeksforgeeks.org/circular-matrix-construct-a-matrix-with-numbers-1-to-mn-in-spiral-way/
    // https://www.techiedelight.com/create-spiral-matrix-given-array/
    // https://javaconceptoftheday.com/how-to-create-spiral-of-numbers-matrix-in-java/
    public static int[][] helix(int[][] inMatrix) {

        if(inMatrix.length <= 0){
            return null;
        }else{
            int[] numbersArray = new int[inMatrix.length*inMatrix[0].length];  // draw initial matrix
            for(int i = 0; i < inMatrix.length; i++) {
                int[] row = inMatrix[i];
                for(int j = 0; j < row.length; j++) {
                    int number = inMatrix[i][j];
                    numbersArray[i*row.length+j]= number;    // assign the number into the correct position in the matrix
                }
            }
            return createHelixMatrix(numbersArray, inMatrix);    // method to transform initial matrix with numbers
        }                                                        // into the helix matrix

    }

    private static int[][] createHelixMatrix(int[] numbersArray, int[][] initialMatrix){

        int top = 0;
        int bottom = initialMatrix.length -1;
        int left = 0;
        int right = initialMatrix[0].length -1;

        int[][] helixMatrix = new int[initialMatrix.length][initialMatrix[0].length];

        int index = 0;

        while (true)
        {
            if (left > right)
                break;

            for (int i = left; i <= right; i++)
                helixMatrix[top][i] = numbersArray[index++];  // to print the number from left corner to the right corner
            top++;

            if (top > bottom)
                break;

            for (int i = top; i <= bottom; i++)
                helixMatrix[i][right] = numbersArray[index++];  // to print the number from top corner to the bottom corner
            right--;

            if (left > right)
                break;

            for (int i = right; i >= left; i--)
                helixMatrix[bottom][i] = numbersArray[index++];  // to print the number from right corner to the left corner
            bottom--;

            if (top > bottom)
                break;

            for (int i = bottom; i >= top; i--)
                helixMatrix[i][left] = numbersArray[index++];   // to print the number from bottom corner to the top corner
            left++;
        }

        return helixMatrix;
    }
}