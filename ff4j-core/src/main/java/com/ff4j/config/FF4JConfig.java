package com.ff4j.config;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.ff4j.web.ApiConfig;
import org.ff4j.utils.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnClass({FF4j.class})
@ComponentScan(value = {"org.ff4j.spring.boot.web.api", "org.ff4j.services", "org.ff4j.aop", "org.ff4j.spring"})
public class FF4JConfig {
	
	@Value("${ff4j.webapi.authentication}")
    private boolean authentication = false;
    
    @Value("${ff4j.webapi.authorization}")
    private boolean authorization = false;
    
	@Bean
	@Primary
    public FF4j getFF4j() {
        return new FF4j("ff4j.xml");
    }
	
	@Bean
    public FF4jDispatcherServlet getFF4JServlet() {
        FF4jDispatcherServlet ds = new FF4jDispatcherServlet();
        ds.setFf4j(getFF4j());
        return ds;
    }
	
//	@Bean
//    public ApiConfig getApiConfig() {
//        ApiConfig apiConfig = new ApiConfig();
//        
//        // Enable Authentication on API KEY
//        apiConfig.setAuthenticate(false);
//        apiConfig.createApiKey("apikey1", true, true, Util.set("ADMIN", "USER"));
//        apiConfig.createApiKey("apikey2", true, true, Util.set("ADMIN", "USER"));
//        apiConfig.createUser("userName","password", true, true, Util.set("ADMIN", "USER"));
//        apiConfig.createUser("user","userPass", true, true, Util.set("ADMIN", "USER"));
//        apiConfig.createUser("a","a", true, true, Util.set("ADMIN", "USER"));
//        apiConfig.createUser("b","b", true, true, Util.set("ADMIN", "USER"));
//        
//        apiConfig.setAutorize(authorization);
//        apiConfig.setWebContext("/api");
//        apiConfig.setPort(5000);
//        apiConfig.setFF4j(getFF4j());
//        return apiConfig;
//    }
}
