package cn.flaty.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import cn.flaty.config.properties.TomcatPoolDataSourceProperties;

@Configuration
@MapperScan("cn.flaty.persitance")
public class DataSourceConfig {

	@Autowired
	private TomcatPoolDataSourceProperties config;

	@Bean
	public DataSource dataSource() {
		DataSource pool = new DataSource();
		pool.setDriverClassName(config.getDriverClassName());
		pool.setUrl(config.getUrl());
		pool.setUsername(config.getUsername());
		pool.setPassword(config.getPassword());
		pool.setInitialSize(config.getInitialSize());
		pool.setMaxActive(config.getMaxActive());
		pool.setMaxIdle(config.getMaxIdle());
		pool.setMinIdle(config.getMinIdle());
		pool.setTestOnBorrow(config.isTestOnBorrow());
		pool.setTestOnReturn(config.isTestOnReturn());
		pool.setValidationQuery(config.getValidationQuery());
		return pool;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
