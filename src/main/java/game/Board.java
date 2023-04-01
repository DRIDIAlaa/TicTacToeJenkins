package game;

public class Board {
	private String[][] board;
	
	public Board() {
		this.board = this.initializeBoard();
	}

	/**
	 * Règles métier:
	 * - le plateau fait 3 lignes et 3 colonnes
	 * - toutes les cases sont vides au début du jeu
	 */
	public String[][] initializeBoard() {
		String[][] newBoard = new String[3][3];
		for (int line = 0; line < 3; line++) {
			for (int col = 0; col < 3; col++) {
				newBoard[line][col] = " ";
			}
		}
		return newBoard;
	}
	
	/**
	 * Règles métier :
	 * - les valeurs possibles pour le param "joueur" sont 1 (les croix) ou 2 (les ronds), toute autre valeur lève une exception
	 * - il n'est pas possible de jouer sur une case occupée, cela lève une exception
	 * - place un signe croix ou rond aux coordonnées en arguments
	 * - le reste du plateau ne change pas
	 * @throws GameRuleException
	 */
	public void playTurn(int player, int line, int col) throws GameRuleException {
		if (this.board[line][col] != " ") {
			throw new GameRuleException("Cette case est déjà occupée.");
		}
		if (player != 1 && player != 2) {
			throw new GameRuleException("Ce joueur n'existe pas.");
		}
		if (player == 1) {
			this.board[line][col] = "x";
		} else if (player == 2) {
			this.board[line][col] = "o";
		}
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}
}
