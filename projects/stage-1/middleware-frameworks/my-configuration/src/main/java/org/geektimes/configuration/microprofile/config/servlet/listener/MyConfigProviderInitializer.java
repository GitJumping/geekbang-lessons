package org.geektimes.configuration.microprofile.config.servlet.listener;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyConfigProviderInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Thread.currentThread().setContextClassLoader(sce.getServletContext().getClassLoader());
        ConfigProviderResolver resolver = ConfigProviderResolver.instance();
        Config config = resolver.getBuilder().forClassLoader(Thread.currentThread().getContextClassLoader())
                .addDefaultSources().addDiscoveredSources().addDiscoveredConverters().build();
        resolver.registerConfig(config, Thread.currentThread().getContextClassLoader());
        ConfigProviderResolver.setInstance(resolver);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        ConfigProviderResolver resolver = ConfigProviderResolver.instance();
        Config config = resolver.getConfig(context.getClassLoader());
        resolver.releaseConfig(config);
    }
}
