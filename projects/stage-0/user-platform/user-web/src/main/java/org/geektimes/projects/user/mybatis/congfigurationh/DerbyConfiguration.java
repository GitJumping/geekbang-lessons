package org.geektimes.projects.user.mybatis.congfigurationh;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DerbyConfiguration {

    @Bean
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:derby:user-platform;create=true");
        dataSource.setUser("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

}