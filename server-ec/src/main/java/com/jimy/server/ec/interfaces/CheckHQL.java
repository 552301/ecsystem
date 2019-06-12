package com.jimy.server.ec.interfaces;

import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author jimy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Target({ElementType.FIELD,ElementType.LOCAL_VARIABLE,ElementType.PARAMETER,ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface CheckHQL {
    String message() default "jimy自定义注解";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
