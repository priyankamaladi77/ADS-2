import java.util.Set;
import java.util.HashSet;
public class BoggleSolver {
	private Set<String> validWords;
	private TrieST<Integer> trie;
	private boolean[][] marked;
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	
	public BoggleSolver(String[] dictionary) {
		TrieST<Integer> trie = new TrieST<Integer>();
		Set<String> validWords = new HashSet<String>();
		int n = 0;
		for (int i = 0; i < dictionary.length; i++) {
		 	if (dictionary[i].length() >= 0 && dictionary[i].length() <= 2) {
		 		n = 0;
		 	} else if (dictionary[i].length() >= 3 && dictionary[i].length() <= 4) {
		 		n = 1;
		 	} else if (dictionary[i].length() == 5) {
		 		n = 2;
		 	} else if (dictionary[i].length() == 6) {
		 		n = 3;
		 	} else if (dictionary[i].length() == 7) {
		 		n = 5;
		 	} else {
		 		n = 11;
		 	}
		 	trie.put(dictionary[i], n);
		}
	}
	//
	// Returns the set of all valid words in the given Boggle board, as an
	// Iterable.
	//
	// @param      board  The board
	//
	// @return     All valid words.
	//
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		marked = new boolean[board.rows()][board.cols()];
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				String sb = appendCharacter("", board.getLetter(i, j));
				dfs(board, marked, i, j, sb);
			}
		}
		return validWords;
	}
	private String appendCharacter(String sb, char character) {
		if (character == 'Q') {
			return sb + "QU";
		} else {
			return sb + character + "";
		}
	}
	private boolean isValidWord(String word) {
		if (word.length() < 3) {
			return false;
		}
		return trie.contains(word);
	}

	public void dfs(BoggleBoard board, boolean[][] marked,
		int r, int c, String word) {
		if (isValidWord(word)) {
			validWords.add(word);
		}
		marked[r][c] = true;
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (i >= 0 && j >= 0 && r < board.rows() && c < board.cols() && !marked[i][j] ) {
					dfs(board, marked, i, j, word);
					word = appendCharacter(word, board.getLetter(i, j));
				}
			}
		}
		marked[r][c] = false;
	}
	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (word == null) return 0;
		if (trie.contains(word)) {
				return trie.get(word);
			}
		return 0;
	}
}
