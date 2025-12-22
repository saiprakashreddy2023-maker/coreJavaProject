public class Multiparameter {

    public static void main(String[] args) {
        interface Max {
            int findMin(int a, int b);
        }


        Max min = (a, b) -> {
            if (a > b) {
                return a;
            } else {
                return b;
            }
        };

        System.out.println("Maximum value is: " + min.findMin(10, 20));
    }
}
interface Max {
    int findMax(int a, int b);
}
