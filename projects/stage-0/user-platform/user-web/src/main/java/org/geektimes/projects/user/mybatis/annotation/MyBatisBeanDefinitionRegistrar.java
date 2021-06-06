/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geektimes.projects.user.mybatis.annotation;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * TODO Comment
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since TODO
 * Date : 2021-05-06
 */
public class MyBatisBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment environment;
    private final static String PROPERTIES_PREFIX = "spring.ibatis";

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(SqlSessionFactoryBean.class);

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableMyBatis.class.getName());
        /**
         *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         *   <property name="dataSource" ref="dataSource" />
         *   <property name="mapperLocations" value="classpath*:" />
         *  </bean >
         */
        beanDefinitionBuilder.addPropertyReference("dataSource", (String) attributes.get("dataSource"));
        // Spring String 类型可以自动转化 Spring Resource
        beanDefinitionBuilder.addPropertyValue("configLocation", attributes.get("configLocation"));
        beanDefinitionBuilder.addPropertyValue("mapperLocations", attributes.get("mapperLocations"));
        beanDefinitionBuilder.addPropertyValue("environment", resolvePlaceholder(attributes.get("environment")));
        // 自行添加其他属性

        // SqlSessionFactoryBean 的 BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        String beanName = (String) attributes.get("value");
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    private void loadEnvironmentProperties(BeanDefinitionBuilder beanDefinitionBuilder) {
        if (environment == null) {
            return;
        }
        String datasource = environment.getProperty(PROPERTIES_PREFIX + ".dataSource", "dataSource");
        System.out.println("datasource = " + datasource);
        beanDefinitionBuilder.addPropertyReference("dataSource", datasource);

        String configLocation = environment.getProperty(PROPERTIES_PREFIX + ".configLocation");
        System.out.println("configLocation = " + configLocation);
        if (StringUtils.hasText(configLocation)) {
            beanDefinitionBuilder.addPropertyValue("configLocation", configLocation);
        }

        String mapperLocations = environment.getProperty(PROPERTIES_PREFIX + ".mapperLocations");
        System.out.println("mapperLocations = " + mapperLocations);
        if (StringUtils.hasText(mapperLocations)) {
            String[] arr = mapperLocations.split(",");
            beanDefinitionBuilder.addPropertyValue("mapperLocations", arr);
        }

        String e = environment.getProperty(PROPERTIES_PREFIX + ".environment");
        System.out.println("e = " + e);
        if (StringUtils.hasText(e)) {
            Object value = resolvePlaceholder(e);
            beanDefinitionBuilder.addPropertyValue("environment", value);
        }

        String typeHandlersPackage = environment.getProperty(PROPERTIES_PREFIX + ".typeHandlersPackage");
        System.out.println("typeHandlersPackage = " + typeHandlersPackage);
        if (StringUtils.hasText(typeHandlersPackage)) {
            beanDefinitionBuilder.addPropertyValue("typeHandlersPackage", typeHandlersPackage);
        }

        String typeAliasesPackage = environment.getProperty(PROPERTIES_PREFIX + ".typeAliasesPackage");
        System.out.println("typeAliasesPackage = " + typeAliasesPackage);
        if (StringUtils.hasText(typeAliasesPackage)) {
            beanDefinitionBuilder.addPropertyValue("typeAliasesPackage", typeAliasesPackage);
        }
    }

    private Object resolvePlaceholder(Object value) {
        if (value instanceof String) {
            return environment.resolvePlaceholders((String) value);
        }
        return value;
    }

    private void resolveEnableMyBatisAttributes(Map<String, Object> attributes, BeanDefinitionBuilder beanDefinitionBuilder) {
        if (attributes == null) {
            return;
        }
        /**
         *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
         *   <property name="dataSource" ref="dataSource" />
         *   <property name="mapperLocations" value="classpath*:" />
         *  </bean >
         */
        String datasource = (String) attributes.get("dataSource");
        if (StringUtils.hasText(datasource)) {
            beanDefinitionBuilder.addPropertyReference("dataSource", datasource);
        }

        String configLocation = (String) attributes.get("configLocation");
        if (StringUtils.hasText(configLocation)) {
            // Spring String 类型可以自动转化 Spring Resource
            beanDefinitionBuilder.addPropertyValue("configLocation", configLocation);
        }

        String[] mapperLocations = (String[]) attributes.get("mapperLocations");
        if (mapperLocations != null && mapperLocations.length > 0) {
            beanDefinitionBuilder.addPropertyValue("mapperLocations",mapperLocations);
        }

        String e = (String) attributes.get("environment");
        if (StringUtils.hasText(e)) {
            beanDefinitionBuilder.addPropertyValue("environment", resolvePlaceholder(e));
        }

        String typeHandlersPackage = (String) attributes.get("typeHandlersPackage");
        if (StringUtils.hasText(typeHandlersPackage)) {
            beanDefinitionBuilder.addPropertyValue("typeHandlersPackage", typeHandlersPackage);
        }


        String typeAliasesPackage = (String) attributes.get("typeAliasesPackage");
        if (StringUtils.hasText(typeAliasesPackage)) {
            beanDefinitionBuilder.addPropertyValue("typeAliasesPackage", typeAliasesPackage);
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
