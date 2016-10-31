package com.boom.dianna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description: 主入口
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.boom.dianna.dao")
@EntityScan("com.boom.dianna.model")
@ImportResource(value = {"classpath:META-INF/spring/ssogo-provider.xml"})
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public FilterRegistrationBean jwtFilterRegistrationBean(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        HTTPBearerAuthorizeAttribute httpBearerFilter = new HTTPBearerAuthorizeAttribute();
//        registrationBean.setFilter(httpBearerFilter);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/user/getusers");
//        registrationBean.setUrlPatterns(urlPatterns);
//        return registrationBean;
//    }
}