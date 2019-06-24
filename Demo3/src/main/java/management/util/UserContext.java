package management.util;

import management.pojo.Administrator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

//封装当前登录用户的上下文信息
public class UserContext {
    private static final String USER_IN_SESSION = "user_in_session";
    public static HttpSession getSession(){
        return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }
    public static void setCurrentAdministrator(Administrator current){
        if(current == null){
            getSession().invalidate();
        }else {
            getSession().setAttribute(USER_IN_SESSION,current);
        }
    }
    public static Administrator getCurrentAdministrator(){
        return (Administrator) getSession().getAttribute(USER_IN_SESSION);
    }
}
