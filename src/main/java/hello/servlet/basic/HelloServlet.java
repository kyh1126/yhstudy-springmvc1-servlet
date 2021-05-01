package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿 애노테이션
// - name: 서블릿 이름
// - urlPatterns: URL 매핑
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        // http://localhost:8080/hello
        // tomcat, jetty, undertow 같은 was 가 서블릿 표준 스펙을 구현하는데, 그 구현체가 찍힌다.
        // request = org.apache.catalina.connector.RequestFacade@2e7be4e5
        // response = org.apache.catalina.connector.ResponseFacade@4b34af1a
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // http://localhost:8080/hello?username=kim
        // 서블릿은 쿼리 파라미터를 읽기 편하게 지원해준다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // Header 정보에 들어간다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // HTTP message body 에 데이터가 들어간다.
        response.getWriter().write("hello "+username);
    }
}
