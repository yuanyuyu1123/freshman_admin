package com.rs.config.server;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


@Configuration
@MapperScan(basePackages = "com.rs.dao")
public class MybatisAutoConfiguration {
    @Resource(name = "mybatisProperties")
    private MybatisProperties mybatisProperties;

    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(mybatisProperties.getDriverClassName());
        dataSource.setUrl(mybatisProperties.getUrl());
        dataSource.setUsername(mybatisProperties.getUser());
        dataSource.setPassword(mybatisProperties.getPassword());
        dataSource.setFilters(mybatisProperties.getFilters());
        dataSource.setInitialSize(mybatisProperties.getInitialSize());
        dataSource.setMaxActive(mybatisProperties.getMaxActive());
        dataSource.setMaxWait(mybatisProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(mybatisProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(mybatisProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(mybatisProperties.getValidationQuery());
        dataSource.setTestOnBorrow(mybatisProperties.getTestOnBorrow());
        dataSource.setTestOnReturn(mybatisProperties.getTestOnReturn());
        dataSource.setTestWhileIdle(mybatisProperties.getTestWhileIdle());
        dataSource.setPoolPreparedStatements(mybatisProperties.getPoolPreparedStatements());
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackages());
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            org.springframework.core.io.Resource[] resources = resolver.getResources(mybatisProperties.getMapperLocations());
            sqlSessionFactoryBean.setMapperLocations(resources);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }
}
