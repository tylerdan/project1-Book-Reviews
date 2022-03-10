package spring.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAspect {
    Logger log = Logger.getLogger(BookAspect.class);

    /*@Before("execution(* getBook*(..))")
    public void BeforeGettingBook(Joinpoint joinpoint) {
        log.info("Getting book(s)");
    }*/
}
