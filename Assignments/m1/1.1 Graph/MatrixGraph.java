import java.util.Scanner;
/**
 * Class for graph matrix.
 */
class MatrixGraph {
    /**
     * No.of Vertices of type int.
     */
    private int vertices;
    /**
     * No.of Edges of type int.
     */
    private int edges;
    /**
     * Scanner Object.
     */
    private Scanner sc;
    /**
     * String input array.
     */
    private String[] input;
    /**
     * Matrix 2D Array.
     */
    private int[][] matrix;
    /**
     * Count to check no.of edges.
     */
    private int count;
    /**
     * Constructs the object.
     */
    MatrixGraph() {
        //default constructor.
    }

    /**
     * Constructs the object.
     *
     * @param      scan    The screen
     */
    MatrixGraph(final Scanner scan) {
        sc = scan;
        vertices = Integer.parseInt(sc.nextLine());
        edges = Integer.parseInt(sc.nextLine());
        input = sc.nextLine().split(",");
        matrix = new int[vertices][vertices];
        count = 0;
    }

    /**
     * No.of Vertices.
     * The time complexityis constant.
     * @return     { Returns int }
     */
    public int vert() {
        return vertices;
    }

    /**
     * No.of Edges.
     * The time complexityis constant.
     * @return     { Returns int }
     */
    public int edge() {
        return edges;
    }

    /**
     * Adds an edge.
     * The time complexity is constant.
     * It uses hasEdge to check whether it is connected or not.
     *
     * @param      vert1  The vertical 1
     * @param      vert2  The vertical 2
     */
    public void addEdge(final int vert1, final int vert2) {
        if (!hasEdge(vert1, vert2)) {
            matrix[vert1][vert2] = 1;
            matrix[vert2][vert1] = 1;
            count++;
        }
    }

    /**
     * Determines if it has edge.
     * The time complexity is constant.
     *
     * @param      v     { Vertex 1 }
     * @param      w     { Vertex 2 }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        return matrix[v][w] == 1;
    }

    /**
     * Iterable iterates the Array.
     * The time complexity is O(N).
     *
     * @param      v     { Integer value }
     *
     * @return     { Returns the Iterable of integer type }
     */
    public Iterable<Integer> adj(final int v) {
        return null;
    }

    /**
     * To String method to print the Matrix representation of graph.
     * The time complexity is N ^ 2.
     * It iterates through out the 2D Array.
     *
     * @return     { Returns the String }
     */
    public String tostring() {
        String str = vert() + " vertices, " + count + " edges" + "\n";
        if (count == 0) {
            str += "No edges";
            return str;
        }
        int i;
        for (i = 0; i < vert(); i++) {
            for (int j = 0; j < vert(); j++) {
                str += matrix[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }
}
