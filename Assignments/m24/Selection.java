import java.util.Scanner;
/**
 * Class for Selection.
 */
public class Selection {
    /**
     * Constructs the object of selection sort.
     */
    Selection() {
        //empty constructor.
    }
    /**
     * { exchanges the elements in ith index with min index}.
     * Time complexity : constant
     * @param      arr   comparable array
     * @param      i     { index }
     * @param      min   index
     */
    private static void exchange(Comparable[] arr, int i, int min) {
        Comparable swap = arr[i];
        arr[i] = arr[min];
        arr[min] = swap;
    }
    /**
     * { function for comparing two objects }.
     * The time complexity is constant because only 1 statment
     * executes when it is called.
     * @param      arr1     { Comparable object }
     * @param      arr2     { Comparable object }
     *
     * @return     { returns -1 if condition is satisfied else returns 1 }
     */
    private static boolean less(Comparable arr1, Comparable arr2) {
         return (arr1.compareTo(arr2)) < 0;
    }
    /**
     * { sorts all the elements in an array using insertion sort }.
     * The time complexity is O(N^2) beacuse both for loops iterates
     * through size of array.
     * @param      arr   comparable array
     */
    public static void sort(Comparable[] arr) {
        int num = arr.length;
        for (int i = 0; i < num; i++) {
            int min = i;
            for (int j = i + 1; j < num; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
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
     * selection sorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split("", str.length());
        Stopwatch stopWatch = new Stopwatch();
        Selection.sort(temp);
        show(temp);
        double time = stopWatch.elapsedTime();
        System.out.println(time);
    }
}
