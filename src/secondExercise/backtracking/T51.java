package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T51 {


    List<List<String>> ans = new ArrayList<>();
    char[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessBoard[i],'.');
        }
        backtracking(chessBoard, 0, n);
        return ans;
    }

    public void backtracking(char[][] board, int index, int n) {

        if (index == n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(index, i, n)) {
                board[index][i] = 'Q';
                backtracking(board, index + 1, n);
                board[index][i] = '.';
            }
        }
    }

    public boolean valid(int x, int y, int n) {
        //上方
        for (int i = 0; i < x; i++) {
            if (chessBoard[i][y] == 'Q') {
                return false;
            }
        }

        //45度
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }

        //135度
        for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
