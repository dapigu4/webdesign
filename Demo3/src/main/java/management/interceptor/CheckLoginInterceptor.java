package management.interceptor;

import management.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(UserContext.getCurrentAdministrator()== null){
            response.sendRedirect("/login.html");
            System.out.println("prehandler");
            return false;
        }
        return true;
    }
}
