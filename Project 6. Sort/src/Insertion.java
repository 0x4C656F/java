public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {5, 2, 7, 0, 3, 9};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // default: [13, 75, 12, 4, 18, 6, 9, 10, 7, 14, 15]
    // 1: [13, 75, 12, 4, 18, 6, 9, 10, 7, 14, 15] – Initial state
    // 2: [13, 75, 12, 4, 18, 6, 9, 10, 7, 14, 15] – No changes, 75 is already in correct position relative to 13
    // 3: [12, 13, 75, 4, 18, 6, 9, 10, 7, 14, 15] – 12 inserted before 13
    // 4: [4, 12, 13, 75, 18, 6, 9, 10, 7, 14, 15] – 4 moved to the front
    // 5: [4, 12, 13, 18, 75, 6, 9, 10, 7, 14, 15] – 18 inserted after 13
    // 6: [4, 6, 12, 13, 18, 75, 9, 10, 7, 14, 15] – 6 inserted between 4 and 12
    // 7: [4, 6, 9, 12, 13, 18, 75, 10, 7, 14, 15] – 9 inserted between 6 and 12
    // 8: [4, 6, 9, 10, 12, 13, 18, 75, 7, 14, 15] – 10 inserted between 9 and 12
    // 9: [4, 6, 7, 9, 10, 12, 13, 18, 75, 14, 15] – 7 inserted between 6 and 9
    // 10: [4, 6, 7, 9, 10, 12, 13, 14, 18, 75, 15] – 14 inserted between 13 and 18
    // 11: [4, 6, 7, 9, 10, 12, 13, 14, 15, 18, 75] – 15 inserted between 14 and 18    
}
