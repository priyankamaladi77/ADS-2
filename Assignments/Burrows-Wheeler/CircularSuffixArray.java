import java.util.Arrays;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.SuffixArrayX;
public class CircularSuffixArray {
    private SuffixArrayX suffix;

    public CircularSuffixArray(String str) {
        if (str == null) throw new NullPointerException();
        suffix = new SuffixArrayX(str);
    }

    public int length() {
        return suffix.length();
    }

    /**
     * returns index of ith sorted suffix
     *
     * @param i
     *            the index of the ith sorted suffix
     * @return
     */
    public int index(int i) {
        return suffix.index(i);
    }
}
