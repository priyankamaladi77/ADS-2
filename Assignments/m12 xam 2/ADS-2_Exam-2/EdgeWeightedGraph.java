/**
 * Class for edge weighted graph.
 */
class EdgeWeightedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    /**
     * { array list of type bag }.
     */
    private Bag<Edge>[] list;
    /**
     * { vertices of graph }.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      s     { size of graph }
     */
    EdgeWeightedGraph(final int s) {
        this.V = V;
        this.E = 0;
        list = new Bag[s];
        size = s;
        for (int i = 0; i < s; i++) {
            list[i] = new Bag();
        }
    }

    /**
     * Adds an edge.
     * {The time complexity is constant}
     * @param      e     { edge }
     */
    public void addEdge(final Edge e) {
        int pos = e.either();
        int pos1 = e.other(pos);
        list[pos].add(e);
        list[pos1].add(e);
    }
    /**
     * { vertices }
     * The time complexity is constant.
     * @return     { count of vertices in graph }
     */
    public int vertices() {
        return size;
    }
    /**
     * { adj verices }
     * The time complexity is e.
     * @param      v     { vertices }
     *
     * @return     { adjecent vertices }
     */
    public Iterable<Edge> adj(final int v) {
        return list[v];
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : list[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
