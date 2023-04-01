package game;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		displayBoard(board.getBoard());
		
		try {
			board.playTurn(1, 0, 0);
			displayBoard(board.getBoard());
			board.playTurn(2, 0, 1);
		} catch (GameRuleException e) {
			e.printStackTrace();
		}
		
		displayBoard(board.getBoard());
	}

	/**
	 * Affiche le plateau de jeu dans la console.
	 * @param board
	 */
	private static void displayBoard(String[][] board) {
		System.out.println("-----");
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("-----\n");
	}
}
