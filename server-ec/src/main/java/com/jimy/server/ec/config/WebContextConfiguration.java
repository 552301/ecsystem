package com.jimy.server.ec.config;

import com.jimy.ec.core.interfaces.EnumConverterFactory;
import com.jimy.ec.core.interfaces.IEnumInfomation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author jimy
 * @create 2019/3/21
 * @since 1.0.0
 */
@Configuration
public class WebContextConfiguration {
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    /**
     * Get web context web context.
     *
     * @param request the request
     * @return the web context
     */
//    @Bean
//    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public WebContext getWebContext(@Autowired HttpServletRequest request) {
//        return new WebContext(request);
//    }
    /**
     * Add conversion config.
     */
    @PostConstruct
    public void addConversionConfig() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        if (initializer != null && initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            if (genericConversionService != null) {
                genericConversionService.addConverterFactory(new EnumConverterFactory());
            }

        }
    }
}
