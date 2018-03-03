package spring.fun;

public class RandomLoped implements Loped{

    @InjectRandomInt(min = 2, max = 7)
    private int random;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void lope() {
        for (int i = 0; i<random; i++) {
            System.out.println(message);
        }
    }
}
