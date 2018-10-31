public class CC {
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;

    /**
     * Computes the connected components of the undirected graph G.
     *
     * @param G the undirected graph
     */
    public CC(Graph G) {
        marked = new boolean[G.vertices()];
        id = new int[G.vertices()];
        size = new int[G.vertices()];
        for (int v = 0; v < G.vertices(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }
    /**
     * Computes the connected components of the edge-weighted graph G.
     *
     * @param G the edge-weighted graph
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Gives the component id of the connected component containing vertex.
     *
     * @param      v     { parameter_description }
     *
     * @return returns the component id of the connected component containing vertex
     */
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    /**
     * Returns the number of vertices in the connected component containing
     * vertex v.
     *
     * @param      v     the vertex
     *
     * @return     the number of vertices in the connected component containing
     *             vertex v.
     */
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /**
     * Returns the number of connected components in the graph G.
     *
     * @return the number of connected components in the graph G.
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if vertices v and w are in the same
     * connected component.
     *
     * @param      v     one vertex
     * @param      w     the other vertex
     *
     * @return returns true if vertices v and w are in the
     * same connected component;false otherwise
     */
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * Returns true if vertices v and w are in the same
     * connected component.
     *
     * @param      v     one vertex
     * @param      w     the other vertex
     *
     * @return true if vertices v and w are in the
     *  same connected component; false otherwise.
     */
    public boolean areConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    private void validateVertex(int v) {
        int V = marked.length;
    }
}
