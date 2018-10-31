import java.util.Iterator;
import java.util.NoSuchElementException;
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * { vertices }
     */
    private final int Ver;
    /**.
     * { edges }
     */
    private int Edg;
    /**.
     * { adj }
     */
    private boolean[][] adj;
    /**
     * Constructs the object.
     *
     * @param      V     { vertices }
     */
    public Graph(int Ver1) {
        if (Ver1 < 0) throw new IllegalArgumentException("Too few vertices");
        this.Ver = Ver1;
        this.Edg = 0;
        this.adj = new boolean[Ver][Ver];
    }
    /**
     * { vertices }.
     *
     * @return     { count of vertices }
     */
    public int Ver() {
        return Ver;
    }
    /**.
     * { edges }
     *
     * @return     { count }
     */
    public int Edg() {
        return Edg;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { v }
     * @param      w     { w }
     */
    public void addEdge(int v, int w) {
        if (!adj[v][w]) Edg++;
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
    public boolean contains(int v, int w) {
        return adj[v][w];
    }
    /**
     * { adjecent }
     *
     * @param      v     { v }
     *
     * @return     { adjecent keys }
     */
    public Iterable<Integer> adj(int v) {
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
         * @param      v     { v }
         */
        AdjIterator(int v) {
            this.v = v;
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
            while (w < Ver) {
                if (adj[v][w]) return true;
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
        s.append(Ver + " " + Edg + NEWLINE);
        for (int v = 0; v < Ver; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
