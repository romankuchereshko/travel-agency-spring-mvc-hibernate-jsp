package com.travel.agency.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HibernateConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

//    @Override
//    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
//        var dispatcher = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
//        dispatcher.setThrowExceptionIfNoHandlerFound(true);
//        return dispatcher;
//    }
}