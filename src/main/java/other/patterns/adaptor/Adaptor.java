package other.patterns.adaptor;

public class Adaptor implements AdaptorInterface {

    private AdapteeInterface adaptee;

    @Override
    public void doSmthToClient() {
        adaptee.doSmthAnotherButClientWantsIt();
    }

    public void setAdaptee(AdapteeInterface adaptee) {
        this.adaptee = adaptee;
    }
}
