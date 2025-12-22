public class NoParameterLambdaExample {

    public static void main(String[] args) {


        Runnable r = () -> System.out.println("Hello from no-parameter lambda");

        r.run();
    }
}
