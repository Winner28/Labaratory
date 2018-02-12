package spring.model.ioc;

import lombok.Value;

@Value
public class SimpleContact implements Contact {
    private String email;
    private String number;
}
