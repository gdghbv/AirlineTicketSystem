package com.example.airline_ticket_system_idea.interceptors;

import com.example.airline_ticket_system_idea.util.JwtUtil;
import com.example.airline_ticket_system_idea.util.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌认证
        String token=request.getHeader("Authorization");
    try{
        Map<String,Object> claims= JwtUtil.parseToken(token);
// 把存储到ThreadLocal中的用户信息设置到request中
        ThreadLocalUtil.set(claims);
        return true;
    }catch (Exception e){
        response.setStatus(401);
        return false;
    }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      ThreadLocalUtil.remove();
    }
}
