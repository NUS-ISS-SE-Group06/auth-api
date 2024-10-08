package com.nus.iss.tasktracker.interceptor;

import com.nus.iss.tasktracker.dto.UserDTO;
import com.nus.iss.tasktracker.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class TaskTrackerInterceptor implements HandlerInterceptor{

    private final JWTUtil jwtUtil;
    private static final ThreadLocal<String> userNameHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> userRoleHolder = new ThreadLocal<>();
    private static final ThreadLocal<UserDTO> userDetails = new ThreadLocal<>();

    @Autowired
    public TaskTrackerInterceptor(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public static String getLoggedInUserName() {
        return userNameHolder.get();
    }
    public static String getLoggedInUserRole() {
        return userRoleHolder.get();
    }
    public static UserDTO getUserDetails(){return  userDetails.get(); }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandle PRINTED");
        boolean isTokenValid = true;
        String token = null;
        // This method is called before the controller method is invoked.
        // You can perform pre-processing here.
        log.info("Pre-handle method is called - for URL: {} ; Method: {}",request.getRequestURI(), request.getMethod());

        if(request.getHeader("Authorization")!=null){
            token = request.getHeader("Authorization");
            log.info("Authorization header value: {}", token);
            token = token.replaceAll("Bearer ", "");
        }

        // DO TOKEN VALIDATION
        // THROW ERROR IF THE TOKEN IS EMPTY OR THE VALIDATION FAILS
        if(!StringUtils.hasText(token)){
            log.warn("TOKEN IS EMPTY");
            // FIXME
            //throw new Exception("No Token");
        } else{
            log.info("TOKEN IS {}",token);
            String[] subjectRoleValues = jwtUtil.validateJWT(token);
            if((subjectRoleValues==null) || (subjectRoleValues.length!=6) ||
                    (!StringUtils.hasText(subjectRoleValues[0])) || (!StringUtils.hasText(subjectRoleValues[1]))){
                isTokenValid = false;
            } else{
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(subjectRoleValues[0]);
                userDTO.setUserRole(subjectRoleValues[1]);
                userDTO.setName(subjectRoleValues[2]);
                userDTO.setUserId(Integer.parseInt(subjectRoleValues[3]));
                userDTO.setUsername(subjectRoleValues[4]);
                userDTO.setGroupId(Integer.parseInt(subjectRoleValues[5]));
                userDetails.set(userDTO);
                System.out.println("UserDTO: "+userDTO);

                // Set a value in the thread-local variable
                userNameHolder.set(subjectRoleValues[0]);
                userRoleHolder.set(subjectRoleValues[1]);

                System.out.println("UserName: "+subjectRoleValues[0]);
                System.out.println("UserRole: "+subjectRoleValues[1]);
            }
        }
        log.info("Token valid: {}",isTokenValid);

        if(!isTokenValid){
            throw new RuntimeException("Auth Token Validation Failed");
        }

        return true; // Return true to continue with the execution chain, or false to stop it.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // This method is called after the controller method is invoked, but before the view is rendered.
        // You can perform post-processing here.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        // This method is called after the view is rendered.
        // You can perform cleanup activities here.
        userNameHolder.remove();
    }
}