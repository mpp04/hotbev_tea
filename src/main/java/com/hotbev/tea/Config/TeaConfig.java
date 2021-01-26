package com.hotbev.tea.Config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class TeaConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.database-platform}")
    private String dbDialect;

    /**
     * @Bean public DataSource dataSource() {
     * BasicDataSource ds = new BasicDataSource();
     * ds.setDriverClassName(driverName);
     * ds.setUrl(url);
     * ds.setUsername(username);
     * ds.setPassword(password);
     * System.out.println("datasource");
     * return ds;
     * }
     **/
    @Bean
    @Primary
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }


    @Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dsb) {
        LocalSessionFactoryBean sfBean = new LocalSessionFactoryBean();
        sfBean.setDataSource(dsb);
        sfBean.setPackagesToScan("com.hotbev.tea");
        sfBean.setHibernateProperties(getSfProps());
        System.out.println("sessionFact");
        return sfBean;
    }

    @Bean
    HibernateTransactionManager transactionManager(SessionFactory sf) {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sf);
        System.out.println("Transaction");
        return manager;
    }

    private Properties getSfProps() {
        Properties props = new Properties();
        System.out.println("props");
        props.setProperty("hibernate.dialect", dbDialect);
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "none");
        return props;
    }

}
