/**
 * imports Scanner package.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object for solution class.
   */
  private Solution() {
    //default constructor.
  }
  /**
   * Main method.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int ver = Integer.parseInt(scan.nextLine());
    int edg = Integer.parseInt(scan.nextLine());
    EdgeWeightedGraph graph = new EdgeWeightedGraph(ver);
     while (edg > 0) {
            String[] tokens = scan.nextLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            double weight = Double.parseDouble(tokens[2]);
            Edge e = new Edge(a, b, weight);
            graph.addEdge(e);
            edg--;
        }
        LazyPrimMST lp = new LazyPrimMST(graph);
        System.out.printf("%.5f\n", lp.weight());
    }
}
