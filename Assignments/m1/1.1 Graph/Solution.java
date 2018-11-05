/**
 * imports scanner package.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object for solution.
     */
    private Solution() { }
    /**
     * Main Method for Graph.
     * The time complexity is O(N ^ 2).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String token = sc.nextLine();
        switch (token) {
            case "List":
                ListGraph ListGraphist = new ListGraph(sc);
                while (sc.hasNext()) {
                    String[] connection = sc.nextLine().split(" ");
                    int val1 = Integer.parseInt(connection[0]);
                    int val2 = Integer.parseInt(connection[1]);
                    if (val1 != val2) {
                        ListGraphist.addEdge(val1, val2);
                    }
                }
                System.out.println(ListGraphist.tostring());
            break;
            case "Matrix":
                MatrixGraph MatrixGraphrix = new MatrixGraph(sc);
                while (sc.hasNext()) {
                    String[] connection = sc.nextLine().split(" ");
                    int v1 = Integer.parseInt(connection[0]);
                    int v2 = Integer.parseInt(connection[1]);
                    if (v1 != v2) {
                        MatrixGraphrix.addEdge(v1, v2);
                    }
                }
                System.out.println(MatrixGraphrix.tostring());
            break;
            default:
            break;
        }
    }
}
