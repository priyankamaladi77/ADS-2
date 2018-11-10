import java.util.ArrayList;
import java.util.Scanner;
public final class Solution {
	private Solution() {
		//default constructor.
	}
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		String[] roadlines = sc.nextLine().split(" ");
		ArrayList<Integer> roads = new ArrayList<Integer>();
		for (int i = 0; i < roadlines.length; i++) {
            roads.add(Integer.parseInt(roadlines[i]));
        }
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			EdgeWeightedGraph graph = new EdgeWeightedGraph(n);
        for (int j = 0; j < k; j++) {
            String[] input = sc.nextLine().split(" ");
            graph.addEdge(new Edge(roads.indexOf(input[0]),
                roads.indexOf(input[1]),
                Integer.parseInt(input[2])));
        }
        System.out.println(graph);
		break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}