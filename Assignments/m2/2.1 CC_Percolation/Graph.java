import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for graph.
 */
public class Graph {
    /**
     * { var_description }.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * { vertices }
     */
    private final int vertices;
    /**.
     * { edges }
     */
    private int edges;
    /**.
     * { adj }
     */
    private boolean[][] adj;
    /**
     * Constructs the object.
     *
     * @param      V1     { vertices }
     */
    public Graph(final int v1) {
        if (v1 < 0) {
            throw new IllegalArgumentException("Too few vertices");
        }
        this.vertices = v1;
        this.edges = 0;
        this.adj = new boolean[vertices][vertices];
    }
    /**
     * { vertices }.
     *
     * @return     { count of vertices }
     */
    public int vertices() {
        return this.vertices;
    }
    /**.
     * { edges }
     *
     * @return     { count }
     */
    public int edges() {
        return this.edges;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { v }
     * @param      w     { w }
     */
    public void addEdge(final int v, final int w) {
        if (!adj[v][w]) {
            edges++;
        }
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**
     * { contains }.
     *
     * @param      v     { v }
     * @param      w     { w }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int v, final int w) {
        return adj[v][w];
    }
    /**
     * { adjecent }.
     *
     * @param      v     { v }
     *
     * @return     { adjecent keys }
     */
    public Iterable<Integer> adj(final int v) {
        return new AdjIterator(v);
    }
    /**
     * Class for adj iterator.
     */
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        /**.
         * { v }
         */
        private int v;
        /**.
         * { w }
         */
        private int w = 0;
        /**
         * Constructs the object.
         *
         * @param      v1     { v }
         */
        AdjIterator(final int v1) {
            this.v = v1;
        }
        /**
         * { iterator }.
         *
         * @return     { graph }
         */
        public Iterator<Integer> iterator() {
            return this;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            while (w < vertices) {
                if (adj[v][w]) {
                    return true;
                }
                w++;
            }
            return false;
        }
        /**.
         * { next }
         *
         * @return     { w }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        /**
         * {removes}.
         */
        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " " + edges + NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
