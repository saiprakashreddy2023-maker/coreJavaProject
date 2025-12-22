import java.util.*;

public class Streams{

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "Sai", "Reddy", "Suresh", "Prakash", "Sunil"
        );

        names.stream()
                .filter(name -> name.startsWith("R"))
                .map(name -> name.toLowerCase())
                .forEach(name -> System.out.println(name));
    }
}
