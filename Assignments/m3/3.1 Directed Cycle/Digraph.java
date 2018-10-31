/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * { var_description }
     */
    private final int vertices;
    /**
     * { var_description }
     */
    private int edges;
    /**
     * { var_description }
     */
    private Bag<Integer>[] adj;
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  ver1  the number of vertices
     */
    public Digraph(int ver1) {
        this.vertices = ver1;
        this.edges = 0;
        adj = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int vertices() {
        return vertices;
    }

    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int edges() {
        return edges;
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param      v     the tail vertex
     * @param      w     the head vertex
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        edges++;
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param      v     the vertex
     *
     * @return     the vertices adjacent from vertex {@code v} in this digraph,
     *             as an iterable
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
