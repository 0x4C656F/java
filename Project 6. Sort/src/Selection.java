public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
// 1: [4, 75, 12, 13, 18, 6, 9, 10, 7, 14, 15] - Swapped 4 with 13
// 2: [4, 6, 12, 13, 18, 75, 9, 10, 7, 14, 15] - Swapped 6 with 75
// 3: [4, 6, 7, 13, 18, 75, 9, 10, 12, 14, 15] - Swapped 7 with 12
// 4: [4, 6, 7, 9, 18, 75, 13, 10, 12, 14, 15] - Swapped 9 with 13
// 5: [4, 6, 7, 9, 10, 75, 13, 18, 12, 14, 15] - Swapped 10 with 18
// 6: [4, 6, 7, 9, 10, 12, 13, 18, 75, 14, 15] - Swapped 12 with 75
// 7: [4, 6, 7, 9, 10, 12, 13, 14, 75, 18, 15] - Swapped 14 with 18
// 8: [4, 6, 7, 9, 10, 12, 13, 14, 15, 18, 75] - Swapped 15 with 18
// 9: [4, 6, 7, 9, 10, 12, 13, 14, 15, 18, 75] - No swap needed
}

