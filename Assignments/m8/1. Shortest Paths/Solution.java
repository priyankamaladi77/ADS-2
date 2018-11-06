import java.util.ArrayList;
/**
 * imports scanner package.
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
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		sc.nextLine();
		String[] stations = sc.nextLine().split(" ");
		ArrayList<String> stationslist = new ArrayList<String>();
		for (int i = 0; i < stations.length; i++) {
			stationslist.add(stations[i]);
		}
		EdgeWeightedGraph graph = new EdgeWeightedGraph(v);
		for (int j = 0; j < e; j++) {
			String[] input = sc.nextLine().split(" ");
			graph.addEdge(new Edge(stationslist.indexOf(input[0]),
				stationslist.indexOf(input[1]),
				Integer.parseInt(input[2])));
		}
		int q = Integer.parseInt(sc.nextLine());
		for (int k = 0; k < q; k++) {
			String[] l = sc.nextLine().split(" ");
			ShortestPath sp = new ShortestPath(graph, stationslist.indexOf(l[0]));
			System.out.println((int) sp.distTo(stationslist.indexOf(l[1])));
		}
	}
}
