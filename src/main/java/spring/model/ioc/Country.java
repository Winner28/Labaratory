package spring.model.ioc;

public interface Country {
    Country withId(Long id);
    Long getId();
    String getName();
    String getCodeName();
}
