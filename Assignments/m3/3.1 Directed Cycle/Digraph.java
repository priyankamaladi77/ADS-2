/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * { vertices of type int}.
     */
    private final int vertices;
    /**
     * { edges of type int }.
     */
    private int edges;
    /**
     * { adj array of type bag }.
     */
    private Bag<Integer>[] adj;
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  ver1  the number of vertices
     */
    public Digraph(final int ver1) {
        this.vertices = ver1;
        this.edges = 0;
        adj = new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     * Time complexity is constant.
     * @return the number of vertices in this digraph
     */
    public int vertices() {
        return vertices;
    }

    /**
     * Returns the number of edges in this digraph.
     * Time complexity is constant.
     * @return the number of edges in this digraph
     */
    public int edges() {
        return edges;
    }

    /**
     * Adds the directed edge v→w to this digraph.
     * Time complexity is constant.
     * @param      v     the tail vertex
     * @param      w     the head vertex
     */
    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        edges++;
    }

    /**
     * Returns the vertices adjacent from vertex v in this digraph.
     * Time complexity is constant.
     * @param      v     the vertex
     *
     * @return     the vertices adjacent from vertex v in this digraph,
     *             as an iterable
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
}
