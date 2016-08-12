package pl.iqa.init.jetty;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.AnnotationConfiguration.ClassInheritanceMap;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.WebApplicationInitializer;
import pl.iqa.init.IqaWebApplicationInitializer;

public class EmbeddedJetty {

    private static final int DEFAULT_PORT = 8080;

    private final Server server;

    public EmbeddedJetty(Integer port, String appName) {
        this.server = new Server(port == null ? DEFAULT_PORT : port);
        this.server.setHandler(createWebAppContext(appName));
    }

    public void startAndJoin() throws Exception {
        server.start();
        server.join();
    }

    private WebAppContext createWebAppContext(String appName) {
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setConfigurations(new Configuration[]{new AnnotationConfiguration()});
        webAppContext.setContextPath("/" + appName);
        webAppContext.setAttribute(AnnotationConfiguration.CLASS_INHERITANCE_MAP, createClassInheritanceMap());
        return webAppContext;
    }

    private ClassInheritanceMap createClassInheritanceMap() {
        ClassInheritanceMap map = new ClassInheritanceMap();
        ConcurrentHashSet set = new ConcurrentHashSet();
        set.add(IqaWebApplicationInitializer.class.getName());
        map.put(WebApplicationInitializer.class.getName(), set);
        return map;
    }
}
