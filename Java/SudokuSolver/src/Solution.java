import java.nio.CharBuffer;
import java.util.Arrays;

class Solution {
	public void solveSudoku(char[][] board) {
		fillSudoku(board, 0);
		System.out.println(Arrays.deepToString(board));
	}

	private boolean fillSudoku(char[][] board, int row) {
		for (int i = row; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					for (char ch = '1'; ch <= '9'; ch++) {
						if (isValid(board, i, j, ch)) {
							board[i][j] = ch;
							if (fillSudoku(board, i)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char num) {
		return isValidRowsCols(board, row, col, num) && isValidGrid(board, row, col, num);
	}

	private boolean isValidRowsCols(char[][] board, int row, int col, char num) {
		boolean hasNum = CharBuffer.wrap(board[row]).chars().mapToObj(ele -> (char) ele).filter(ch -> ch == num)
				.findFirst().isPresent();
		if (!hasNum) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][col] == num) {
					hasNum = true;
					break;
				}
			}
		}

		return !hasNum;
	}

	private boolean isValidGrid(char[][] board, int row, int col, char num) {
		int rowGridIndex = row - row % 3;
		int colGridIndex = col - col % 3;

		for (int i = rowGridIndex; i < rowGridIndex + 3; i++) {
			for (int j = colGridIndex; j < colGridIndex + 3; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		sol.solveSudoku(board);
	}
}