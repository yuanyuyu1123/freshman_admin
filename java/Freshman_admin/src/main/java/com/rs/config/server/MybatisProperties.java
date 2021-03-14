package com.rs.config.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mybatis.properties")
public class MybatisProperties {

    @Value("${mybatis.driverClassName}")
    private String driverClassName;

    @Value("${mybatis.url}")
    private String url;

    @Value("${mybatis.username}")
    private String user;

    @Value("${mybatis.password}")
    private String password;

    @Value("${mybatis.typeAliasesPackages}")
    private String typeAliasesPackages;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Value("${mybatis.filters}")
    private String filters;

    @Value("${mybatis.initialSize}")
    private Integer initialSize;

    @Value("${mybatis.maxActive}")
    private Integer maxActive;

    @Value("${mybatis.maxWait}")
    private Long maxWait;

    @Value("${mybatis.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${mybatis.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;

    @Value("${mybatis.validationQuery}")
    private String validationQuery;

    @Value("${mybatis.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${mybatis.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${mybatis.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${mybatis.poolPreparedStatements}")
    private Boolean poolPreparedStatements;

    public MybatisProperties() {
    }

    public MybatisProperties(String driverClassName, String url, String user, String password, String typeAliasesPackages, String mapperLocations, String filters, Integer initialSize, Integer maxActive, Long maxWait, Long timeBetweenEvictionRunsMillis, Long minEvictableIdleTimeMillis, String validationQuery, Boolean testWhileIdle, Boolean testOnBorrow, Boolean testOnReturn, Boolean poolPreparedStatements) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.user = user;
        this.password = password;
        this.typeAliasesPackages = typeAliasesPackages;
        this.mapperLocations = mapperLocations;
        this.filters = filters;
        this.initialSize = initialSize;
        this.maxActive = maxActive;
        this.maxWait = maxWait;
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
        this.validationQuery = validationQuery;
        this.testWhileIdle = testWhileIdle;
        this.testOnBorrow = testOnBorrow;
        this.testOnReturn = testOnReturn;
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeAliasesPackages() {
        return typeAliasesPackages;
    }

    public void setTypeAliasesPackages(String typeAliasesPackages) {
        this.typeAliasesPackages = typeAliasesPackages;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Long maxWait) {
        this.maxWait = maxWait;
    }

    public Long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public Long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    @Override
    public String toString() {
        return "MybatisProperties{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", typeAliasesPackages='" + typeAliasesPackages + '\'' +
                ", mapperLocations='" + mapperLocations + '\'' +
                ", filters='" + filters + '\'' +
                ", initialSize='" + initialSize + '\'' +
                ", maxActive='" + maxActive + '\'' +
                ", maxWait='" + maxWait + '\'' +
                ", timeBetweenEvictionRunsMillis='" + timeBetweenEvictionRunsMillis + '\'' +
                ", minEvictableIdleTimeMillis='" + minEvictableIdleTimeMillis + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                ", testWhileIdle='" + testWhileIdle + '\'' +
                ", testOnBorrow='" + testOnBorrow + '\'' +
                ", testOnReturn='" + testOnReturn + '\'' +
                ", poolPreparedStatements='" + poolPreparedStatements + '\'' +
                '}';
    }
}
