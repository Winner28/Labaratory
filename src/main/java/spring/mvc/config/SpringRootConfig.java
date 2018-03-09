package spring.mvc.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("spring")
public class SpringRootConfig {


    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("util.properties"));
        dataSource.setDriverClassName(properties.getProperty("jdbc.mysql.driverClass"));
        dataSource.setUrl(properties.getProperty("jdbc.mysql.url"));
        dataSource.setUsername(properties.getProperty("jdbc.mysql.username"));
        dataSource.setPassword(properties.getProperty("jdbc.mysql.password"));
        return dataSource;
    }

}
