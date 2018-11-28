/**.
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * { marked array of type boolean}.
     */
    private boolean[] marked;
    /**
     * { edge to of type int}.
     */
    private int[] edgeTo;
    /**
     * { on stack of type boolean}.
     */
    private boolean[] onStack;
    /**
     * { cycle stack }.
     */
    private Stack<Integer> cycle;
    /**
     * Constructs the object.
     *
     * @param      g     { digraph }
     */
    public DirectedCycle(final Digraph g) {
        marked  = new boolean[g.vertices()];
        onStack = new boolean[g.vertices()];
        edgeTo  = new int[g.vertices()];
        for (int v = 0; v < g.vertices(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(g, v);
            }
        }
    }
    /**
     * { depth first search }.
     *  The time complexity is O(E + V) e refers to no of
     * edges, v refers to no.of vertices.
     * @param      g     { graph }
     * @param      v     { vertex }
     */
    private void dfs(final Digraph g, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    /**
     * Determines if it has cycle.
     * Time complexity is constant.
     * @return     True if has cycle, False otherwise.
     */
    public boolean hasCycle() {
        return cycle != null;
    }
}
