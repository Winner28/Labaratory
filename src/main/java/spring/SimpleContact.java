package spring;

import lombok.Value;

@Value

public class SimpleContact implements Contact {
    private String email;
    private String number;
}
