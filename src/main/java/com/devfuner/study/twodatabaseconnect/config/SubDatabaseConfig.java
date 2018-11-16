package com.devfuner.study.twodatabaseconnect.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.devfuner.study.twodatabaseconnect.sub", sqlSessionFactoryRef = "subSqlSessionFactory")
@EnableTransactionManagement
public class SubDatabaseConfig {

    @Bean(name = "subDataSource")
    @ConfigurationProperties(prefix = "spring.datasoruce.hikari.sub")
    public DataSource subDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "subSqlSessionFactory")
    public SqlSessionFactory subSqlSessionFactory(
            @Qualifier("subDataSource") DataSource dataSource
            , ApplicationContext applicationContext
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/sub/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "subSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory subSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(subSqlSessionFactory);
    }
}
