package com.spring.blog2.config;

import com.github.pagehelper.PageInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

;

@Configuration
public class MybatisPageHelperConfig {
    private static final Logger log = LoggerFactory.getLogger(MybatisPageHelperConfig.class);

    @Bean
    public PageInterceptor pageInterceptor() {
        log.info("------Register MyBatis PageHelper-------");
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
//        通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
        p.setProperty("pageSizeZero", "true");
        pageInterceptor.setProperties(p);
        return pageInterceptor;
    }

}
