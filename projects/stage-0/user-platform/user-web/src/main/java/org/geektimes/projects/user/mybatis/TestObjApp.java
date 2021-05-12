package org.geektimes.projects.user.mybatis;

import org.geektimes.projects.user.mybatis.annotation.EnableMyBatis;
import org.geektimes.projects.user.mybatis.mapperh.TestObjMapper;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;


@EnableMyBatis(
        basePackages = "me.young1lin.geeklesson.mybatis.mapper",
        mapperLocations = {"classpath*:mappers/**/*.xml"},
        environment = "development")
@SpringBootApplication
public class TestObjApp {

    public static void main(String[] args) {
        MapperScan mapperScan = AnnotatedElementUtils.getMergedAnnotation(TestObjApp.class, MapperScan.class);
        assert mapperScan != null;
        System.out.println(mapperScan.basePackages()[0]);
        AnnotationConfigServletWebServerApplicationContext context = (AnnotationConfigServletWebServerApplicationContext) SpringApplication.run(TestObjApp.class);
        IngredientMapper mapper = context.getBean(IngredientMapper.class);
        mapper.getAll().forEach(System.out::println);
    }

}
