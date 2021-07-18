package org.geektimes.configuration.microprofile.config.servlet.listener;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.geektimes.configuration.microprofile.config.source.MyConfigSources;
import org.geektimes.configuration.microprofile.config.source.MyServletRequestConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.UUID;

public class MyServletRequestConfigurationRegister  implements ServletRequestListener {
    public final String CONFIG_NAME = "indi.kurok1.configuration.servlet.name";

    private ConfigProviderResolver getConfigProviderResolver() {
        return ConfigProviderResolver.instance();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ConfigProviderResolver resolver = getConfigProviderResolver();
        ServletRequest request = sre.getServletRequest();
        ServletContext context = sre.getServletContext();
        String configName = (String) request.getAttribute(CONFIG_NAME);
        if (configName != null) {
            Config config = resolver.getConfig(context.getClassLoader());
            MyConfigSources configSources = (MyConfigSources) config.getConfigSources();
            configSources.release(configName);
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ConfigProviderResolver resolver = getConfigProviderResolver();
        ServletRequest request = sre.getServletRequest();
        ServletContext context = sre.getServletContext();

        Config config = resolver.getConfig(context.getClassLoader());
        Iterable<ConfigSource> configSources = config.getConfigSources();
        if (configSources instanceof MyConfigSources) {
            String configName = generateConfigName();
            MyServletRequestConfiguration configuration = new MyServletRequestConfiguration(configName, request);
            ((MyConfigSources) configSources).addLast(configuration);
            request.setAttribute(CONFIG_NAME, generateConfigName());
        }
    }

    private String generateConfigName() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return String.format("servlet-%s", uuid);
    }
}
