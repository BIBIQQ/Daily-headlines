package com.heima.app.geteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author FF
 * @date 2022/1/24
 * @TIME:11:30
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient  //开启注册中心
public class GatewayApplication {

        public static void main(String[] args) {
            SpringApplication.run(GatewayApplication.class,args);
        }

}
