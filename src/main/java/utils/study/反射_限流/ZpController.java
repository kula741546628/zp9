package utils.study.反射_限流;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author kula
 * @create 2021/7/5 下午1:25
 */
public class ZpController {
    private RateLimiter rateLimiter = RateLimiter.create(1.0);
}
