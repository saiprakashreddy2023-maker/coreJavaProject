
    class Employee {
        String Company = "abc company ";

        void work() {
            System.out.println("employee is working");
        }
    }

    class Tester extends Employee {
            void test() {
                System.out.println("tester is testing");
            }
        }
public class inheritence{
    public static void main(String[] args) {
        Tester test = new Tester();
        System.out.println(test.Company);
        test.work();
        test.test();

    }

    }


