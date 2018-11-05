/**
 * Class for bipartite.
 */
class Bipartite {
    /**
     * { bipartite variable of type boolean}.
     */
    private boolean isBipartite;
    /**
     * { color of type boolean array}.
     */
    private boolean[] color;
    /**
     * { marked array of type boolean }.
     */
    private boolean[] marked;
    /**
     * { edge to array of type int}.
     */
    private int[] edgeTo;
    /**
     * { cycle of type stack }.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object for class bipartite.
     *
     * @param      graph     { graph }
     */
    Bipartite(final Graph graph) {
        isBipartite = true;
        color  = new boolean[graph.vertices()];
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        for (int v = 0; v < graph.vertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }
    /**
     * { dfs }.
     * {The time complexity is O(V+E)}.
     * @param      g     { g }
     * @param      v     { v }
     */
    private void dfs(final Graph g, final int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (cycle != null) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int i = v; i != w; i = edgeTo[i]) {
                    cycle.push(i);
                }
                cycle.push(w);
            }
        }
    }
    /**
     * Determines if bipartite.
     * The time complexity is constant.
     * @return     True if bipartite, False otherwise.
     */
    public boolean isBipartite() {
        return isBipartite;
    }
}
