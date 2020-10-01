package com.bjsxt.interceptor;

import com.bjsxt.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* 判断用户是否登录
*/
public class LoginInterceptor implements HandlerInterceptor {
        /**

        * 判断用户是否登录
        * @param request
        * @param response
        * @param handler
        * @return
        * @throws Exception
        */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            if(user == null || user.getUsername().length() <= 0){
                response.sendRedirect("/page/login");
                return false;
            }
            return true;
        }

    @Override
    public void postHandle(HttpServletRequest request,
    HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}