package com.rs.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rs.until.JWTUtil;
import com.rs.until.ResponseData;
import com.rs.until.ResponseDataUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class HeaderTokenInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                Object handler) throws Exception {

            ResponseData responseData=null;
            // 获取请求头中的token验证字符串
            String headerToken = request.getHeader("token");
            try {
                Map<String, Object> map = JWTUtil.verifyToken(headerToken);
                if(map==null){
                    responseData = ResponseDataUtils.buildError("402","无效签名");
                    new ObjectMapper().writeValueAsString(responseData);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(responseData);
                    return false;
                }
                if(map.get("stuId")==null&&request.getRequestURL().toString().contains("student")){
                    responseData = ResponseDataUtils.buildError("402","无效签名");
                    new ObjectMapper().writeValueAsString(responseData);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(responseData);
                    return false;
                }

                if(map.get("adminId")==null&&request.getRequestURL().toString().contains("admin")){
                    responseData = ResponseDataUtils.buildError("402","无效签名");
                    new ObjectMapper().writeValueAsString(responseData);
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(responseData);
                    return false;
                }
                return true;
            } catch (SignatureVerificationException e) {
                e.printStackTrace();
                responseData = ResponseDataUtils.buildError("402","无效签名");
            }catch (TokenExpiredException e){
                e.printStackTrace();
                responseData = ResponseDataUtils.buildError("402","token过期");
            }catch (AlgorithmMismatchException e){
                e.printStackTrace();
                responseData = ResponseDataUtils.buildError("402","token算法不一致");
            }catch (Exception e){
                responseData = ResponseDataUtils.buildError("402","token无效");
            }

            new ObjectMapper().writeValueAsString(responseData);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(responseData);
            return false;
        }
}
