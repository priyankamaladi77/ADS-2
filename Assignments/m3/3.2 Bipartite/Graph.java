/**
 * Class for graph.
 */
public class Graph {
    /**
     * { vertices of type int}.
     */
    private int vertices = 0;
    /**
     * { edges of type int}.
     */
    private int edges;
    /**
     * { adj array of type bag }.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object for class graph.
     *
     * @param      v     { v }
     */
    public Graph(final int v) {
        vertices = v;
        edges = 0;
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**.
     * { vertices }
     * The time complexity is constant.
     * @return returns no.of.vertices.
     */
    public int vertices() {
        return vertices;
    }
    /**
     * { edges }.
     * The time complexity is constant.
     * @return returns no.of.edges.
     */
    public int edges() {
        return edges;
    }
    /**
     * Adds an edge.
     * {The time complexity is constant}
     * @param      v     { v }
     * @param      w     { w }
     */
    public void addEdge(final int v, final int w) {
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * { iterator }.
     *
     * @param      v     { v }
     *
     * @return     { iterable }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
}
