import java.util.ArrayList;
import java.util.LinkedList;
import java.text.DecimalFormat;

public class Part0 {

    public static void main(String[] args) {
        int numElements = 100000;
        DecimalFormat formatter = new DecimalFormat("#,###");

        ArrayList<Integer> arrayList = new ArrayList<>();
        testInsertion("ArrayList", arrayList, numElements, formatter);
        testAccess("ArrayList", arrayList, formatter);
        testRemoval("ArrayList", arrayList, formatter);

        LinkedList<Integer> linkedList = new LinkedList<>();
        testInsertion("LinkedList", linkedList, numElements, formatter);
        testAccess("LinkedList", linkedList, formatter);
        testRemoval("LinkedList", linkedList, formatter);
    }

    private static void testInsertion(String listType, java.util.List<Integer> list, int numElements, DecimalFormat formatter) {
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            list.add(0, i);
        }
        long endTime = System.nanoTime();
        System.out.println(listType + " insertion into beginning time: " + formatter.format(endTime - startTime) + " ns");
    }

    private static void testAccess(String listType, java.util.List<Integer> list, DecimalFormat formatter) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        System.out.println(listType + " access time: " + formatter.format(endTime - startTime) + " ns");
    }

    private static void testRemoval(String listType, java.util.List<Integer> list, DecimalFormat formatter) {
        long startTime = System.nanoTime();
        while (!list.isEmpty()) {
            list.remove(0);
        }
        long endTime = System.nanoTime();
        System.out.println(listType + " removal of first element time: " + formatter.format(endTime - startTime) + " ns");
    }
}
