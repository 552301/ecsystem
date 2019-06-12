package com.jimy.ec.core.exception;

import com.jimy.ec.core.enums.EnumExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈全局统一异常处理〉
 *
 * @author 周金明
 * @create 2019/4/26
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseBody
    public RESTException<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
        return handleErrorInfo(request, EnumExceptionCode.SESSIONNOTFOUND.getValue(), exception.getMessage(),"找不到SESSION错误", exception);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public RESTException<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
        return handleErrorInfo(request,EnumExceptionCode.NULLOREMPTY.getValue(), exception.getMessage(),"空值或者空指针错误", exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    @ResponseBody
    public RESTException<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {
        return handleErrorInfo(request,EnumExceptionCode.ILLEGALPROPERTIES.getValue(), exception.getMessage(),"属性错误", exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RESTException<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return handleErrorInfo(request,EnumExceptionCode.EXCEPTION.getValue(), exception.getMessage(),"系统异常", exception);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public RESTException<String> bodyValidExceptionHandler(HttpServletRequest request,MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return handleErrorInfo(request,EnumExceptionCode.METHODARGUMENTNOTVALID.getValue(),fieldErrors.get(0).getDefaultMessage(),"数据验证错误",exception);
    }

    private RESTException<String> handleErrorInfo(HttpServletRequest request,Integer code, String message,String type, Exception exception) {
        BodyRequestWrapper httpServletRequest = null;
        try {
            httpServletRequest = new BodyRequestWrapper(request);
        } catch (IOException e) {
            logger.error("【系统拦截器异常】", e);
        }
        RESTException<String> result = new RESTException<>();
        String bodyStr = httpServletRequest.getBody();

        result.setMessage(message);
        result.setCode(code);
        result.setData(bodyStr);
        result.setUrl(request.getRequestURL().toString());
        logger.error("【" + type + "】", exception);
        return result;
    }
}
