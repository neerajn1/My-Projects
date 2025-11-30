public class charArray {
    public static void main(String[] args) {
        // Values for row and column are 10
        int row = 10;
        int column = 10;

        // Creating 10 x 10 2D char array
        char[][] charArray = new char[row][column];

        // 0 and 9 are treated as characters and is being placed in the 1st column with i representing row and 0 as column
        for (int i = 0; i < row; i++) {
            charArray[i][0] = (char) ('0' + i);
        }

        // Subtracting -1 helps keep 0-9 chars in last column
        for (int i = 0; i < row; i++) {
            charArray[i][column - 1] = (char) ('0' + i);
        }

        // J = 1 skips first and last column to have all remaining spaces have 'A' nested loop
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column - 1; j++) {
                charArray[i][j] = 'A';
            }
        }

        // Output the final result with nested loop
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

