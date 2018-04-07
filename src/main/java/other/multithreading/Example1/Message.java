package other.multithreading.Example1;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String message;

    public boolean isEmpty() {
        return message == null || message.isEmpty();
    }
}

