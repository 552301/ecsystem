package com.jimy.server.ec.interfaces;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author jimy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Component
public class HQLProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!beanName.equals("refundCustomQueryImpl"))
            return bean;
        Field[] fields = bean.getClass().getDeclaredFields();
        String hql = "";
        for (Field f : fields){
            CheckHQL fieldAnnotation = f.getAnnotation(CheckHQL.class);
            if (fieldAnnotation != null){
                try {
                    hql = f.get(bean).toString();
                    System.out.println(hql);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }
//    @Override
//    public void initialize(CheckHQL constraintAnnotation) {
//        System.out.println(" 注解初始化！ ");
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (StringUtils.isEmpty(value)){
//            System.out.println("HQL不能为空");
//            return false;
//        }
//        String field = "";
//        String skh ="(?<=\\()[^\\)]+";
//        Pattern pattern=Pattern.compile(skh);
//        Matcher matcher=pattern.matcher(value);
//        boolean is=matcher.find();
//        if (is) {
//            field = matcher.group();
//            System.out.println(field);
//        }
//
//        return true;
//    }
}
