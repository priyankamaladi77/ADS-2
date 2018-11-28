/**
 * imports Iterator package.
 */
import java.util.Iterator;
/**
 * imports NoSuchElementException package.
 */
import java.util.NoSuchElementException;
/**
 * Class for graph.
 */
public class Graph {
    /**
     * variable NEWLINE of type string.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { vertices of type int}.
     */
    private final int ver;
    /**
     * { edges of type int }.
     */
    private int edg;
    /**
     * { adj 2D matrix of type boolean.
     */
    private boolean[][] adj;
    /**
     * Constructs the object for graph.
     *
     * @param      ver1    { vertices }
     */
    public Graph(final int ver1) {
        if (ver1 < 0) {
            throw new IllegalArgumentException("Too few vertices");
        }
        this.ver = ver1;
        this.edg = 0;
        this.adj = new boolean[ver][ver];
    }
    /**
     * {no.of vertices}.
     * Time complexity is constant as it executes only once.
     * @return {returns count of vertices }
     */
    public int ver() {
        return ver;
    }
    /**
     * { no of edges }.
     *  Time complexity is constant as it executes only once.
     * @return returns count of edges.
     */
    public int edg() {
        return edg;
    }
    /**
     * Adds an edge between two vertices.
     * Time complexity is constant as it executes only once.
     * @param      v     { v }
     * @param      w     { w }
     */
    public void addEdge(final int v, final int w) {
        if (!adj[v][w]) {
            edg++;
        }
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**
     * Checks whether the edge is present or not.
     *
     * @param      v     { v }
     * @param      w     { w }
     *
     * @return returns true if edge occurs, otherwise false.
     */
    public boolean contains(final int v, final int w) {
        return adj[v][w];
    }
    /**
     * Gives the vertices adjacent to vertex v.
     * Time complexity is degree of vertex.
     * @param  v  { v }
     *
     * @return returns the vertices adjacent to vertex v.
     */
    public Iterable<Integer> adj(final int v) {
        return new AdjIterator(v);
    }
    /**
     * Class for adj iterator.
     */
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        /**
         * variable v of type int.
         */
        private int v;
        /**
         * variable w of type int.
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
            while (w < ver) {
                if (adj[v][w]) {
                    return true;
                }
                w++;
            }
            return false;
        }
        /**
         * { next }
         * Time complexity is constant.
         * @return returns w.
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is O(N^2).
     * @return returns String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(ver + " " + edg + NEWLINE);
        for (int v = 0; v < ver; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
