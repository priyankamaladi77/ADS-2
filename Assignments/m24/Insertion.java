import java.util.Scanner;
/**
 * Class for Insertion.
 */
final class Insertion {
    /**
     * Constructs the object of insertion sort.
     */
    private Insertion() {
        //empty constructor.
    }
    /**
     * { exchanges the elements in ith index with min index}.
     * Time complexity : constant
     * @param      arr   comparable array
     * @param      i     { index }
     * @param      j   index
     */
    private static void exchange(final Comparable[] arr,
        final int i, final int j) {
        Comparable swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    /**
     * { function for comparing two objects }.
     * The time complexity is constant because only 1 statment
     * executes when it is called.
     * @param      v     { Comparable object }
     * @param      w     { Comparable object }
     *
     * @return     { returns -1 if condition is satisfied else returns 1 }
     */
    private static boolean less(final Comparable v, final Comparable w) {
         return (v.compareTo(w)) < 0;
    }
    /**
     * { sorts all the elements in an array using insertion sort }.
     * The time complexity is O(N^2) beacuse both for loops iterates
     * through size of array.
     * @param      arr   comparable array
     */
    public static void sort(final Comparable[] arr) {
        int num = arr.length;
        for (int i = 0; i < num; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * print array to standard output.
     *
     * @param      a     { parameter_description }
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
            System.out.println("\n");
    }
    /**
     * Reads in a sequence of strings from standard input;
     * insertion sorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split("", str.length());
        Stopwatch stopWatch = new Stopwatch();
        Insertion.sort(temp);
        show(temp);
        double time = stopWatch.elapsedTime();
        System.out.println(time);
    }
}
