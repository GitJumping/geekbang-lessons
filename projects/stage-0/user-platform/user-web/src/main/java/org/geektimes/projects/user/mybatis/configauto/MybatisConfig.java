package org.geektimes.projects.user.mybatis.configauto;

import org.apache.ibatis.session.SqlSessionFactory;
import org.geektimes.projects.user.mybatis.annotation.EnableMyBatis;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@EnableMyBatis(dataSource = "dataSource")
@ConditionalOnClass(value = {SqlSessionFactoryBean.class, SqlSessionFactory.class})
@Configuration
public class MybatisConfig {
}
