package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller
// 아래 두 조합이 @Controller 랑 같은 역할을 한다. RequestMappingHandlerMapping#isHandler
// @Bean + @RequestMapping 도 가능
@Component
@RequestMapping
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
