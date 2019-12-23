package org.demo.activemq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ActiveProperties
 *
 * @author hss
 * @date 2019/12/19 11:41
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.activemq")
public class ActiveProperties {
    private String brokerUrl;
    private String user;
    private String password;
}
