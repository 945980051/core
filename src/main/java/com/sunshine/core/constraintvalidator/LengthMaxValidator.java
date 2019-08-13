/**
 * 
 */
package com.sunshine.core.constraintvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sunshine.common.utils.ObjectUtils;
import com.sunshine.core.constraints.LengthMax;

/**
 * @author 张梓枫
 * @Description
 * @date: 2019年1月3日 下午3:38:53
 */
public class LengthMaxValidator implements ConstraintValidator<LengthMax, String> {

    private int maxValue;

    public void initialize(LengthMax lengthMax) {
        this.maxValue = lengthMax.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (ObjectUtils.isNotEmpty(value)) {
            return value.trim().length() <= this.maxValue;
        }
        return true;
    }
}
