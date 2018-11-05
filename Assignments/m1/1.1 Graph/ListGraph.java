import java.util.Scanner;
/**
 * Class for ListGraph.
 */
class ListGraph {
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
     * input of type String Array.
     */
    private String[] input;
    /**
     * type bag of Bag Array.
     */
    private Bag<Integer>[] bag;
    /**
     * Count of the Edges of type int.
     */
    private int count;
    /**
     * Constructs the object for ListGraph.
     *
     * @param      vert  The vertical
     */
    ListGraph(final int vert) {
        vertices = vert;
        bag = new Bag[vertices];
    }

    /**
     * Constructs the objectzz.
     *
     * @param      scan    The scanner
     */
    ListGraph(final Scanner scan) {
        sc = scan;
        vertices = Integer.parseInt(sc.nextLine());
        edges = Integer.parseInt(sc.nextLine());
        input = sc.nextLine().split(",");
        bag = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            bag[i] = new Bag();
        }
        count = 0;
    }

    /**
     * Vertices Method.
     * The time complexityis constant.
     * @return     { returns no.of Vertices }
     */
    public int vert() {
        return vertices;
    }

    /**
     * Edges Method.
     * The time complexityis constant.
     * @return     { returns no.of Edges }
     */
    public int edge() {
        return edges;
    }

    /**
     * Adds an edge, connects two vertices.
     * The time complexity is constant.
     *
     * @param      vert1  The vertical 1
     * @param      vert2  The vertical 2
     */
    public void addEdge(final int vert1, final int vert2) {
        if (!hasEdge(vert1, vert2)) {
            bag[vert1].add(vert2);
            bag[vert2].add(vert1);
            count++;
        }
    }
    /**
     * Iterable to iterate no.of keys.
     * The time complexity is O(N).
     * It iterates through the Bag.
     *
     * @param      v     { Integer Value }
     *
     * @return     { Returns Iterable Integer }
     */
    public Iterable<Integer> adj(final int v) {
        return bag[v];
    }

    /**
     * Determines if it has edge.
     * The time complexity is O(N).
     * It iterates through bag in worst case.
     *
     * @param      v     { Vertex Index 1 }
     * @param      w     { Vertex Index 2 }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        Bag bagobj = bag[v];
        return bagobj.contains(w);
    }

    /**
     * To String Method to Print List.
     * The time complexity is O(N ^ 2).
     *
     * @return     { Returns String }
     */
    public String tostring() {
        String str = vert() + " vertices, " + count + " edges" + "\n";
        if (count == 0) {
            str += "No edges";
            return str;
        }
        int i = 0;
        for (i = 0; i < vert() - 1; i++) {
            str += input[i] + ": ";
            for (int word : adj(i)) {
                str += input[word] + " ";
            }
            str += "\n";
        }
        str += input[i] + ": ";
        for (int word : adj(i)) {
            str += input[word] + " ";
        }
        return str;
    }
}
