/**
 * Class for depth first paths.
 */
class DepthFirstPaths {
    /**
     * { var_description }.
     */
    private boolean[] marked;    // marked[v] = is there an s-v path?
    /**
     * { var_description }.
     */
    private int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    /**
     * { var_description }.
     */
    private final int s;         // source vertex
    /**
     * Constructs the object.
     *
     * @param      G     { graph }
     * @param      s     { start }
     */
    DepthFirstPaths(Graph G, int s1) {
        this.s = s1;
        edgeTo = new int[G.Ver()];
        marked = new boolean[G.Ver()];
        validateVertex(s);
        dfs(G, s);
    }
    /**
     * { dfs }.
     *
     * @param      G     { graph }
     * @param      v     { vertex }
     */
    private void dfs(final Graph G, final int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    /**
     * Determines if it has path to.
     *
     * @param      v     { vertex }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }
    /**
     * { validate vertex or not }.
     *
     * @param      v     { v }
     */
    private void validateVertex(final int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
