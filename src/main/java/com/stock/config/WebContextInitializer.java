package com.stock.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { StockConfig.class };
    }   
	
	@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { StockConfig.class };
    }   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
