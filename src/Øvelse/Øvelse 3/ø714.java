public class ø714 {
    public static void main(String[] args) {
        // init sudoku
        int[][] board =
                {{7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 2, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 6, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {1, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 6, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}};
        boolean checkRows = true;
        boolean checkColumns = true;
        // check rows and columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    if (board[i][j] == board[i][k]) checkRows = false;
                    if (board[j][i] == board[k][i]) checkColumns = false;
                }
            }
        }
        // check quadrants
        // insert arrays that partitioned by their resulting value of a division by 3. 0, 1 and 2.
        // each partition is compared with itself in a basis of
        boolean checkQuadrant = true; // setting boolean variable of Quadrant comparing section
        int[] iZero = new int[27];
        int zeroFlag = 0;
        int[] iOne = new int[27];
        int oneFlag = 0;
        int[] iTwo = new int[27];
        int twoFlag = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                switch (j / 3) {
                    case 0: {
                        iZero[zeroFlag++] = board[i][j];
                        break;
                    }
                    case 1: {
                        iOne[oneFlag++] = board[i][j];
                        break;
                    }
                    case 2: {
                        iTwo[twoFlag++] = board[i][j];
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (j == k) continue;
                    switch (i) {
                        case 0: {
                            if (iZero[k] == iZero[j] || iOne[k] == iOne[j] || iTwo[k] == iTwo[j])
                                checkQuadrant = false;
                            break;
                        }
                        case 1: {
                            if (iZero[k + 9] == iZero[j + 9] || iOne[k + 9] == iOne[j + 9] || iTwo[k + 9] == iTwo[j + 9])
                                checkQuadrant = false;
                            break;
                        }
                        case 2: {
                            if (iZero[k + 18] == iZero[j + 18] || iOne[k + 18] == iOne[j + 18] || iTwo[k + 18] == iTwo[j + 18])
                                checkQuadrant = false;
                            break;
                        }
                    }
                }
            }
        System.out.println("checkRows : " + checkRows + " checkColumns : " + checkColumns +
                " checkQuadrant : " + checkQuadrant);
    }
}
