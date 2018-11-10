/**
 * Class for edge.
 */
class Edge {
    /**
     * { start of edge type int }.
     */
    private int start;
    /**
     * { end of edge type int }.
     */
    private int end;
    /**
     * { weight of edge type double }.
     */
    private double weight;
    /**
     * Constructs the object.
     *
     * @param      s     { start }
     * @param      e     { end }
     * @param      w     { weight }
     */
    Edge(final int s, final int e, final double w) {
        start = s;
        end = e;
        weight = w;
    }
    /**
     * { either }.
     * The time complexity is constant.
     * @return     { start }
     */
    public int either() {
        return start;
    }
    /**
     * { other node of edge }.
     * The time complexity is constant.
     * @param      v     { start }
     *
     * @return     { other end of edge }
     */
    public int other(final int v) {
        if (start == v) {
            return end;
        }
        return start;
    }
    /**
     * { compare to }.
     * The time complexity is constant.
     * @param      that  The that
     *
     * @return     { -1 for less 0 for equal 1 for more }
     */
    public int compareTo(final Edge that) {
        if (this.weight < that.weight) {
            return -1;
        } else if (this.weight > that.weight) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
     * { weight }
     * The time complexity is constant.
     * @return     { weight of edge }
     */
    public double weight() {
        return weight;
    }
}
