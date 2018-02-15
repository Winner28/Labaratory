package spring.model.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Data
@Entity
@Table(name = "Country")
@NoArgsConstructor
@AllArgsConstructor
public class SimpleCountry implements Country {

    @Id
    @Wither
    @GeneratedValue
    private Long id;
    private String name;
    private String codeName;

}
