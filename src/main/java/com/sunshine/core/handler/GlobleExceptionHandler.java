/**
 * 
 */
package com.health.core.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sunshine.common.exception.BLogicException;
import com.health.core.bean.ResponseBean;
import com.health.core.constant.ConfigConstant;
import com.health.core.enums.ResultCode;
import com.sunshine.core.utils.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 张梓枫
 * @Description 自定义异常处理
 * @date:   2019年1月3日 下午4:41:07
 */
@Slf4j
@RestControllerAdvice
public class GlobleExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public <T> ResponseBean<T> exceptionHandler(HttpServletRequest request, Exception e) {
        String message = null;
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
            BindingResult bindingResult = ex.getBindingResult();//捕获的所有错误对象
            List<ObjectError> errors = bindingResult.getAllErrors();
            ObjectError error = errors.get(0);
            message = error.getDefaultMessage();//异常内容
        }else if (e instanceof BLogicException) {
            BLogicException be = (BLogicException)e;
            message = be.getLocalizedMessage();
        }else {
            message = ConfigConstant.SYSTEM_ERROR;
        }
        e.printStackTrace();
        log.error(e.getLocalizedMessage());
        return ResponseUtils.createRet(ResultCode.FAIL, message);
    }
}
