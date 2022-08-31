package top.ky.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * start
 *
 * @author Kang Yong
 * @date 2022/8/30
 * @since 1.0.0
 */
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }
}
