package org.icodeit.bookmarks.actuator;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FeedsServiceMetricsAspect {

    private CounterService counterService;

    @Autowired
    public FeedsServiceMetricsAspect(CounterService counterService) {
        this.counterService = counterService;
    }


    @AfterReturning(pointcut = "execution(* org.icodeit.bookmarks.service.FeedsService.allFeeds())")
    public void afterCallingGetFeeds() {
        counterService.increment("counter.calls.get_feeds");
    }

    @AfterThrowing(pointcut = "execution(* org.icodeit.bookmarks.service.FeedsService.allFeeds())", throwing = "e")
    public void afterThrowsException(Exception e) {
        counterService.increment("counter.errors.get_feeds");
    }
}