package com.softserve.travelagency.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
//        (basePackages = "com.softserve.travelagency", excludeFilters = {
//        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
//        @Filter(type = FilterType.ANNOTATION, value = Controller.class)
//})
public class RootConfig {
}