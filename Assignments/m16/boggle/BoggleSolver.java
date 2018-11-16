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
		if (board == null) {
			throw new IllegalArgumentException("board is null");
		}
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
		String str = sb;
			if (character == 'Q') {
				str += "QU";
				return str;
			} else {
				str += character;
				return str;
			}
		}
	private boolean isValidWord(String word) {
		if (word.length() < 3) {
			return false;
		}
		return trie.contains(word);
	}

	public void dfs(BoggleBoard board, boolean[][] marked,
		int rows, int cols, String word) {
		// if (!trie.hasPrefix(word)) {
		// 	return;
		// }
		if (isValidWord(word)) {
			validWords.add(word);
		}
		marked[rows][cols] = true;
		for (int i = rows - 1; i <= rows + 1 && i < rows; i++) {
			for (int j = cols - 1; j <= cols + 1 && j < cols; j++) {
				if (rows >= 0 && cols >= 0 && !marked[i][j] ) {
					String sequence = appendCharacter(word, board.getLetter(i, j));
					dfs(board, marked, i, j, sequence);
				}
			}
		}
		marked[rows][cols] = false;
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
