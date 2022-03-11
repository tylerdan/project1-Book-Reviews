package spring.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
    public static final Logger log = Logger.getLogger(BookAspect.class);

    @Before("execution(* getBook*(..))")
    public void BeforeGettingBook(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* postBook*(..))")
    public void BeforePostingBook(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* updateBook*(..))")
    public void BeforeUpdatingBook(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* deleteBook*(..))")
    public void BeforeDeletingBook(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
}
