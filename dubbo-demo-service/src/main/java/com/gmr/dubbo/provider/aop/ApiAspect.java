package com.gmr.dubbo.provider.aop;

import com.gmr.dubbo.provider.common.constants.LogConstant;
import com.gmr.dubbo.provider.common.utils.DateUtils;
import com.gmr.dubbo.provider.remote.dto.Response;
import com.gmr.dubbo.provider.remote.ex.ApiException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiAspect {

    @Pointcut("@annotation(com.gmr.dubbo.provider.common.annotation.Api)")
    public void api() {
        // pass
    }

    @Around("api()")
    public Object aroundApi(ProceedingJoinPoint pjp) {
        try {
            return process(pjp);
        } catch (Throwable th) {
            return processException(pjp, th);
        }
    }

    private Object process(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        Long currentTime = System.currentTimeMillis();
        LogConstant.COMMON_LOGGER.info("ApiAspect: Request {}.{} at {}", signature.getDeclaringTypeName(),
                signature.getName(), DateUtils.timestampToDatetimeString(currentTime));
        Object obj = pjp.proceed();
        LogConstant.COMMON_LOGGER.info("ApiAspect: spend {} ms.", System.currentTimeMillis() - currentTime);
        return obj;
    }

    private Response processException(ProceedingJoinPoint pjp, Throwable th) {
        Signature signature = pjp.getSignature();
        if (th instanceof ApiException) {
            ApiException apiException = (ApiException) th;
            LogConstant.ERROR_LOGGER.error("ApiAspect: ApiError when request {}.{} with {}, code: {}, ex: {}: {}",
                    signature.getDeclaringTypeName(), signature.getName(), pjp.getArgs(), apiException.getCode(),
                    apiException.getClass(), apiException);
            return Response.error(apiException);
        } else {
            LogConstant.ERROR_LOGGER.error("ApiAspect: Unknown Error when request {}.{} with {}, ex: {}: {}",
                    signature.getDeclaringTypeName(), signature.getName(), pjp.getArgs(), th.getClass(), th);
            return Response.error(new Exception(th));
        }
    }
}
