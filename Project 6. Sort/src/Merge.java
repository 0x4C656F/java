public class Merge {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; 
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lowIndex, int highIndex) {
        if (highIndex <= lowIndex) return; 
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        sort(a, aux, lowIndex, middleIndex);
        sort(a, aux, middleIndex + 1, highIndex);
        merge(a, aux, lowIndex, middleIndex, highIndex);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lowIndex, int middleIndex, int highIndex) {
        for (int k = lowIndex; k <= highIndex; k++) {
            aux[k] = a[k];
        }

        int i = lowIndex; 
        int j = middleIndex + 1;
        for (int k = lowIndex; k <= highIndex; k++) {
            if (i > middleIndex) {
            a[k] = aux[j++];
            } 
            else if (j > highIndex) {
            a[k] = aux[i++];
            } 
            else if (less(aux[j], aux[i])) {
            a[k] = aux[j++];
            } 
            else {
            a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {13, 75, 12, 4, 18, 6, 9, 10, 7, 14, 15};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    // default: [9, 0, 8, 3, 7, 1, 4]
    // 1: [9, 0, 8, 3, 7, 1, 4] – sort the entire array
    // 2: [9, 0, 8] – sort left half
    // 3: [9] – sort left half
    // 3: [0, 8] – sort right half
    // 4: [0] – sort left half
    // 4: [8] – sort right half
    // 4: [0, 8] – merged and sorted
    // 3: [0, 8, 9] – merged and sorted
    // 2: [3, 7, 1, 4] – sort right half
    // 3: [3, 7] – sort left half
    // 4: [3] – sort left half
    // 4: [7] – sort right half
    // 4: [3, 7] – merged and sorted
    // 3: [1, 4] – sort right half
    // 4: [1] – sort left half
    // 4: [4] – sort right half
    // 4: [1, 4] – merged and sorted
    // 3: [1, 3, 4, 7] – merged and sorted
    // 2: [0, 1, 3, 4, 7, 8, 9] – merged and sorted
}
