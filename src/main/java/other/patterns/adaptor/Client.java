package other.patterns.adaptor;

public class Client {

    public static void main(String[] args) {
        Adaptor adaptor = new Adaptor();
        adaptor.setAdaptee(getAdapteeInterface());
        adaptor.doSmthToClient();
    }


    private static AdapteeInterface getAdapteeInterface() {
        return new Adaptee();
    }
}
