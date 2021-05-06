package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 서블릿 자동 등록
// 스프링 부트는 서블릿을 직접 등록해서 사용할 수 있도록 @ServletComponentScan 을 지원한다.
@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    /**
     * 이런 bean 부분을 스프링 부트는 application.properties 값을 보고 서블릿 자동 등록한다.<p>
     * * spring.mvc.view.prefix=/WEB-INF/views/<p>
     * * spring.mvc.view.suffix=.jsp
     */
    /*@Bean
    InternalResourceViewResolver internalResourceViewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }*/
}
