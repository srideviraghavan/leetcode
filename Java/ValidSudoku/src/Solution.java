import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean isValid = false;
		isValid = isValidRowsCols(board) && isValidGrid(board);
		return isValid;
	}

	private boolean isValidRowsCols(char[][] board) {
		boolean isValid = true;
		List<Integer> rowList = new ArrayList<Integer>();
		List<Integer> colList = new ArrayList<Integer>();
		for (int i = 0; i < board.length; i++) {
			rowList.clear();
			colList.clear();
			for (int j = 0; j < board.length; j++) {
				if (Character.isDigit(board[i][j])) {
					rowList.add(Character.getNumericValue(board[i][j]));
				}
				if (Character.isDigit(board[j][i])) {
					colList.add(Character.getNumericValue(board[j][i]));
				}
			}

			if (hasDuplicates(rowList) || hasDuplicates(colList)) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	private boolean isValidGrid(char[][] board) {
		boolean isValid = true;
		List<Integer> grid = new ArrayList<Integer>();
		for (int gridCol = 0; gridCol < board.length && isValid; gridCol += 3) {
			for (int gridRow = 0; gridRow < board.length; gridRow += 3) {
				grid.clear();
				for (int i = gridRow; i < gridRow + 3; i++) {
					for (int j = gridCol; j < gridCol + 3; j++) {
						if (Character.isDigit(board[i][j])) {
							grid.add(Character.getNumericValue(board[i][j]));
						}
					}
				}
				if (hasDuplicates(grid)) {
					isValid = false;
					break;
				}
			}
		}
		return isValid;
	}

	private boolean hasDuplicates(List<Integer> lst) {
		Stream<Integer> a = lst.stream().filter(i -> Collections.frequency(lst, i) > 1);
		return a.count() > 0;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(sol.isValidSudoku(board));
	}
}
