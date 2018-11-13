import java.util.Scanner;

class Solution {
	public static void main(final String[] args) {
		String[] words = loadWords();
		//Your code goes here...
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		TST<Integer> ternary = new TST<Integer>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				ternary.put(words[i].substring(j), j);
			}
		}
		for (String word : ternary.keysWithPrefix(str)) {
			System.out.println(word);
		}
	}
	/**
	 * Loads words.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}
