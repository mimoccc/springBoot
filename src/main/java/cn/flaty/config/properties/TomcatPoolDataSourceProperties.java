package cn.flaty.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import cn.flaty.Application;

/**
 * tomcatDataSourcePool 配置
 * 
 * @author chenxingwang
 *
 */
@Component
@ConfigurationProperties(prefix = "TomcatPool.datasource", ignoreUnknownFields = false)
@Profile(Application.PRODUCTION)
public class TomcatPoolDataSourceProperties {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private int maxActive = 20;
	private int maxIdle = 8;
	private int minIdle = 8;
	private int initialSize = 5;
	private String validationQuery;

	private boolean testOnBorrow = false;

	private boolean testOnReturn = false;

	public String getDriverClassName() {
		return driverClassName;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
}
