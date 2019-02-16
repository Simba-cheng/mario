package org.mario.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 每次controller请求进来，都记录日志信息
 *
 * @author CYX
 */
@Aspect
@Component
public class MyAsperct {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAsperct.class);

    /**
     * 环绕拦截
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* org.mario.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        LOGGER.info("===== 环绕拦截-前 =====");

        // 接收到请求，记录请求内容
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // 记录下请求内容
            LOGGER.info("URL : {}", new Object[]{request.getRequestURL().toString()});
            LOGGER.info("HTTP_METHOD : {}", new Object[]{request.getMethod()});
            LOGGER.info("IP : {}", new Object[]{request.getRemoteAddr()});
            LOGGER.info("CLASS_METHOD : {}", new Object[]{pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName()});
            LOGGER.info("ARGS : {}", new Object[]{Arrays.toString(pjp.getArgs())});
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        Object result = pjp.proceed();

        LOGGER.info("===== 环绕拦截-后 =====");
        return result;
    }

}
