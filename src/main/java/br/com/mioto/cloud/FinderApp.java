package br.com.mioto.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@EnableTransactionManagement
@EnableNeo4jRepositories("br.com.mioto.cloud.dao.repo")
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigurationProperties
@EnableFeignClients
@Slf4j
@SpringBootApplication
public class FinderApp {

	 /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args ) {
        SpringApplication.run( FinderApp.class, args );
    }
}
