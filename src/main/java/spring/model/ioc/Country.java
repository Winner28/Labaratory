package spring.model.ioc;

public interface Country {
    Country withId(Long id);
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    String getCodeName();
    void setCodeName(String codeName);
}
