package other.patterns.adaptor;

public class Adaptee implements AdapteeInterface {


    @Override
    public void doSmthAnotherButClientWantsIt() {
        System.out.println("Clients wants me!");
    }
}
