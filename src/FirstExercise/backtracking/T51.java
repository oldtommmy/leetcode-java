package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {

    List<List<String>> result = new ArrayList<>();
    char[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backtracking(n, 0);
        return result;
    }

    private void backtracking(int n, int row) {
        if (n == row) {
            result.add(ArrayToList(n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n)) {
                chessboard[row][i] = 'Q';
                backtracking(n, row + 1);
                chessboard[row][i] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n) {

        //列
        for (int i = 0; i < n; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        //45度
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        //135度
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> ArrayToList(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(String.valueOf(chessboard[i]));
        }
        return list;
    }

}
