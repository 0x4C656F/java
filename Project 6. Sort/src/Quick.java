public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); 
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) return;
        int j = partition(a, lowIndex, highIndex); 
        sort(a, lowIndex, j - 1);  
        sort(a, j + 1, highIndex); 
    }

    private static int partition(Comparable[] a, int lowIndex, int highIndex) {
        int i = lowIndex;
        int j = highIndex + 1;
        Comparable v = a[lowIndex];
        while (true) {
            while (less(a[++i], v)) if (i == highIndex) break;
            while (less(v, a[--j])) if (j == lowIndex) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lowIndex, j);
        return j;  
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] a = {9, 0, 8, 3, 7, 1, 4};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

class StdRandom {
    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + (int) (Math.random() * (N - i));  
            Object swap = a[i];
            a[i] = a[r];
            a[r] = swap;
        }
    }
}
