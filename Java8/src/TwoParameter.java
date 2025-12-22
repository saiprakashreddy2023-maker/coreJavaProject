public class TwoParameter {

    public static void main(String[] args) {
        interface Add {
            int sum(int a, int b);}

        Add add = (a, b) -> a + b;

        System.out.println("Sum is: " + add.sum(10, 20));
    }
}
