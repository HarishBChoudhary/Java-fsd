package com.ty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import com.ty.filter.UserAuthenticationFilter;
import com.ty.repositry.UserRepository;

import jakarta.servlet.DispatcherType;


public class FilterConfig {

	@Bean
    public FilterRegistrationBean<UserAuthenticationFilter> registrationFilter(@Autowired UserRepository userRepository) {
        FilterRegistrationBean<UserAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new UserAuthenticationFilter(userRepository));
        registrationBean.addUrlPatterns("/citizens","/citizens/*","/vaccinationcenter","/vaccinationcenter/*","/me");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return registrationBean;
    }
}
