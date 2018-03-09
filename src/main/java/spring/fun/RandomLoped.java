package spring.fun;

public class RandomLoped {

    @InjectRandomInt(min = 2, max = 7)
    private int random;

    private String message;

    private void init() {
        System.out.println("init");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public void lope() {
        for (int i = 0; i<random; i++) {
            System.out.println(message);
        }
    }
}
