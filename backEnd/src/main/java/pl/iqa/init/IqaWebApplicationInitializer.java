package pl.iqa.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.iqa.init.config.IqaServicesConfig;
import pl.iqa.init.config.IqaWebConfig;

public class IqaWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{IqaServicesConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{IqaWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
