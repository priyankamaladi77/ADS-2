/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object for solution class.
	 */
	private Solution() {
		//default constructor.
	}
	/**
	 * main method for sorting the series of strings.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Quick3string nums = new Quick3string();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLine();
		}
		nums.sort(arr);
		String str = "[";
		for (String word:arr) {
			str += word + ", ";
		}
		System.out.println(str.substring(0, str.length() - 2)  + "]");
	}
}
