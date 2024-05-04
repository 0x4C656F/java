public class App {
    //Part 1. Recursion

    public int sum1toN(int n ) { // You may assume n ≥ 1 
        return n == 1 ? 1 : n + sum1toN(n - 1);
      } 
    public static double power(double x, int n){
        if(n == 0){
            return 1;
        }
        return x * power((double) x, (int)n-1);
    }
    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.sum1toN(6));
        double a = power( 2, 3);
        System.out.println(a);
    }
}
