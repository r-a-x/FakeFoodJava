package io.mauth.fakefood.core.aspect;

import io.mauth.fakefood.util.ObjectStringifier;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anupk
 */
@Aspect
@Component
@Order(0)
public class LoggingAspect implements FakeFoodAspect {

    private static final Logger logger = LoggerFactory.getLogger("io.mauth.fakefood.core.annotation.Loggable");

    @AfterThrowing(pointcut = "(execution(* *.*(..)) && @annotation(io.mauth.fakefood.core.annotation.Loggable)) || (@within(io.mauth.fakefood.core.annotation.Loggable))", throwing = "ex")
    public void logErrors(final JoinPoint joinPoint, Throwable ex) throws Throwable {
        performLoggingAfterThrowing(joinPoint, ex);
    }

    public void performLoggingAfterThrowing(final JoinPoint joinPoint, final Throwable t) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = joinPoint.getTarget().getClass().getName() + "." + method.getName();

        Class[] parameterTypes = ((CodeSignature) joinPoint.getSignature()).getParameterTypes();

        String[] parameterNames = getParameterNames(method);

        String params = getParams(joinPoint.getArgs(), parameterNames, method.getParameterAnnotations());

        processError(joinPoint.getTarget().getClass().getName(), methodName, params, t);
    }

    public Object performLogging(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = joinPoint.getTarget().getClass().getName() + "." + method.getName();

        Class[] parameterTypes = ((CodeSignature) joinPoint.getSignature()).getParameterTypes();

        String[] parameterNames = getParameterNames(method);

        String params = getParams(joinPoint.getArgs(), parameterNames, method.getParameterAnnotations());

        Object responseObject = null;
        try {
            responseObject = joinPoint.proceed();

            return responseObject;
        } catch (Throwable t) {
            responseObject = t.getStackTrace();

            processError(joinPoint.getTarget().getClass().getName(), methodName, params, t);

            throw t;
        }
    }

    private String[] getParameterNames(Method method) {
        Parameter[] parameters = method.getParameters();
        List<String> paramNames = new ArrayList<String>();
        for (Parameter param : parameters) {
            paramNames.add(param.getName());
        }

        return paramNames.toArray(new String[0]);
    }

    private String getParams(final Object[] params, final String[] parameterNames, final Annotation[][] annotations) {
        StringBuilder paramsLog = new StringBuilder();

        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                paramsLog.append("&");
            }
            paramsLog.append(new ObjectStringifier().toString(params[i], parameterNames[i], annotations[i]));
        }

        return paramsLog.toString();
    }

    private String[] evaluateParamsNamesFrom(final Class<?>[] parameterTypes) {
        List<String> paramNames = new ArrayList<String>();
        for (Class<?> paramType : parameterTypes) {
            paramNames.add(paramType.getSimpleName());
        }

        return paramNames.toArray(new String[0]);
    }

    private void processError(String className, String methodName, String params,
                              final Throwable t) {
        // sink exeptions to log file
        StringBuffer sb = new StringBuffer();
        sb.append("Error in ");
        sb.append(":Class:");
        sb.append(className);
        sb.append(":Method:");
        sb.append(methodName);
        sb.append(":Parameters:");
        sb.append(params);

        logger.error(sb.toString(), t);
    }
}
