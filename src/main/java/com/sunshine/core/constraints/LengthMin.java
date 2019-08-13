/**
 * 
 */
package com.health.core.constraints;

import javax.validation.Payload;

/**
 * @author 张梓枫
 * @Description 自定义字符串最小长度校验
 * @date:   2019年1月3日 下午3:48:34
 */
public @interface LengthMin {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}
