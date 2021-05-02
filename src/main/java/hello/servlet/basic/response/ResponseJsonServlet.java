package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.request.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/response-json
 */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setHeader("content-type", "application/json");
        // 출력 시 response.getWriter().write(result); 로 사용하고,
        // 이 부분 주석 시, Content-Type: application/json;charset=ISO-8859-1 로 자동 추가해버린다.
//        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);

        //{"username":"kim","age":20}
        // 객체를 문자열로 바꾸는 부분
        String result = objectMapper.writeValueAsString(data);

//        response.getWriter().write(result);
        // 이렇게 사용 시 Response Header 의 Content-Type: application/json
        response.getOutputStream().write(result.getBytes());
    }
}
