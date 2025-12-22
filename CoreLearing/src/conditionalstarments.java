public class conditionalstarments {
    public static void main(String[] args) {
        String[] names = {"sai", "reddy", "prakash"};
        int[] marks = {60, 95, 90};
        char grade;
        System.out.println("Names amd marks");
        System.out.println("-----------------------");
        for (int t = 0; t < names.length; t++) {
            if (marks[t] >= 95) {
                grade = 'a';
            } else if (marks[t] > 80) {
                grade = 'b';
            } else if (marks[t] >60) {
                grade = 'c';
            } else {
                grade = 'f';
            }

                    System.out.println("Name:" + names[t]);
                    System.out.println("Marks:" + marks[t]);
                    System.out.println("Grade:" + grade);
            System.out.println("---------------------");

                }

            }
        }




