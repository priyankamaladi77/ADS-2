/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object for solution.
	 */
	private Solution() {
		//default constructor.
	}
	/**
	 * demonstrates whether cycle exists in the graph or not. 
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		Digraph digraph = new Digraph(v);
        for (int i = 0; i < e; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            digraph.addEdge(n, m);
        }
        DirectedCycle dc = new DirectedCycle(digraph);
        if (dc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
	}
}
