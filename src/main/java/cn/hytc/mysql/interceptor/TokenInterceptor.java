package cn.hytc.mysql.interceptor;

import cn.hytc.mysql.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        if(url.contains("login")){
            return true;
        }
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.error("token is null");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        try{
            // 解析jwt
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.error("token is invalid, jwt={}, error={}", jwt, e.toString());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        log.info("token is valid");
        return true;
    }
}