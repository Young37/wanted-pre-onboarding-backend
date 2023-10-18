package shop.younghk37.wanted.recruitment.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import shop.younghk37.wanted.recruitment.exception.IllegalRequestException;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidAop {

    @Pointcut("@annotation(shop.younghk37.wanted.recruitment.aop.annotation.ValidAop)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] args = proceedingJoinPoint.getArgs();
        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class) {
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult == null) {
            return proceedingJoinPoint.proceed();
        }

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            throw new IllegalRequestException(errorMap);
        }

        Object target = proceedingJoinPoint.proceed();
        return target;
    }
}