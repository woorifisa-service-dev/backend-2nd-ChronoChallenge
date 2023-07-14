package dev.chrono.chronochallenge.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Around("execution(* dev.chrono.chronochallenge.*.controller.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        UUID uuid = UUID.randomUUID();
        log.info("경로: {} / {}", uuid, signature);
        Object p = pjp.proceed();
        log.info("{} / {} 종료", uuid, signature);
        return p;
    }
}
