package spring.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public class ReviewAspect {
    Logger log = Logger.getLogger(ReviewAspect.class);

    @Before("execution(* getReview*(..))")
    public void BeforeGettingReview(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* postReview*(..))")
    public void BeforePostingReview(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* updateReview*(..))")
    public void BeforeUpdatingReview(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* deleteReview*(..))")
    public void BeforeDeletingReview(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
    @Before("execution(* average*(..))")
    public void BeforeAverageReview(JoinPoint joinpoint) {
        log.info(joinpoint.getSignature());
    }
}
