/**
 * Class for shortest path.
 */
class ShortestPath {
    /**
     * { distanceTo array of type double}.
     */
    private double[] distTo;
    /**
     * { edgeTo array of type Edge}.
     */
    private Edge[] edgeTo;
    /**
     * { min pq  of type indexMin}.
     */
    private IndexMinPQ<Double> pq;
    /**
     * Constructs the object.
     * { The time complexity is O(E+V)}
     * @param      g     { g }
     * @param      s     { s }
     */
    ShortestPath(final EdgeWeightedGraph g, final int s) {
        distTo = new double[g.vertices()];
        edgeTo = new Edge[g.vertices()];
        for (int v = 0; v < g.vertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        pq = new IndexMinPQ<Double>(g.vertices());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (Edge e : g.adj(v)) {
                relax(e, v);
            }
        }
    }
    /**
     * { relaxing edge }.
     * {The time complexity is O(logE)}
     * @param      e     { e }
     * @param      v     { v }
     */
    private void relax(final Edge e, final int v) {
        int w = e.other(v);
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
             pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }
    /**
     * { distance to }
     * The time complexity is constant.
     * @param      v     { v }
     *
     * @return     { distance from source }
     */
    public double distTo(final int v) {
        return distTo[v];
    }
    /**
     * Determines if it has path to.
     * The time complexity is constant.
     * @param      v     { v }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
}
