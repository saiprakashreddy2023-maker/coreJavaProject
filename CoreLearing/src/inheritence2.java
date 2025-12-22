 class Dog{
    String Animal=("Animal quality's");
    void barks(){
        System.out.println("dog is barking");
    }
}
class cat extends Dog{
    void sound(){
        System.out.println("cat making sound");
    }
}
class Lion extends cat{
    void noise(){
        System.out.println("loin making noise");
    }
}
public class inheritence2
{
    public static void main(String[] args) {
        Lion l= new Lion();
        System.out.println(l.Animal);
        l.noise();
        l.barks();
        l.sound();
    }
}
