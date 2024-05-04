import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Part 1.1: "+sum1toN(5));
        System.out.println("Part 1.2: "+power(2,3));
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("Negative test case for Part 2.1: "+recLinearSearch(list, "e", 0, 2));// Negative test case;
        System.out.println("Positive test case for Part 2.1: "+recLinearSearch(list, "e", 0, 4));// Positive test case;
        System.out.println("Positive test case for Part 2.2: "+binarySearch(a, 4));// Positive test case;
        System.out.println("Negative test case for Part 2.2: "+binarySearch(a, 11));// Negative test case;

        System.out.println("Positive test case for Part 2.2(recursive): "+recursiveBinarySearch(a, 4, 0, 9));// Positive test case;
        System.out.println("Negative test case for Part 2.2(recursive): "+recursiveBinarySearch(a, 11, 0, 9));// Negative test case;



    }

    static int sum1toN(int n){
        if(n == 1) return 1;
        return n + sum1toN(n-1);
    }
    //This has to be filmed Part 1.2
    static double power(double x, int n){
        if(n == 0) return 1 ;
        return x * power(x,n-1);
    }
    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx){
        String beginValue = list.get(beginIdx);
        if(beginValue == key) return beginIdx;
        if(beginIdx == endIdx) return -1;
        return recLinearSearch(list, key, beginIdx + 1 , endIdx);
    }
    static int[] a = {1,2,3,4,5,6,7,8,9,10};

    //this has to be filmed Part 2.2
    public static int binarySearch(int[] a, int search){
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        while (leftIndex <= rightIndex){
            int middle = (leftIndex + rightIndex) / 2;
            int middleValue = a[middle];
            if(middleValue == search){
                return middle;
            }else if(middleValue > search){
                rightIndex = middle - 1;
            }else{
                leftIndex = middle + 1;
            }
        }
    
        return -1;
    }
    
    //this has to be filmed Part 2.2
    public static int recursiveBinarySearch(int[] a, int search, int low, int high){
        int middle = (low + high) /2;
        int middleValue = a[middle];
        if(low > high) return -1; //the search value is not in the array
        if(middleValue == search) return middle; //the search value is found
        else if(middleValue > search){
            return recursiveBinarySearch(a, search, low, middle-1); //search is in first part of arr - search the left side
        }else{
            return recursiveBinarySearch(a, search, middle+1,high); //search is in second part of arr - search the right side
        }
         
    }

}
