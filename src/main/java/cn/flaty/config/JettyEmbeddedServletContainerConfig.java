package cn.flaty.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "server", ignoreUnknownFields = false)
public class JettyEmbeddedServletContainerConfig {
	private Integer maxThreads = 20;
	private Integer minThreads = 10;
	private Integer idleTimeout = 60000;
	private String address = "0.0.0.0";
	private String contextPath = "";
	private Integer port = 8080;

	public void setMaxThreads(Integer maxThreads) {
		this.maxThreads = maxThreads;
	}

	public void setMinThreads(Integer minThreads) {
		this.minThreads = minThreads;
	}

	public void setIdleTimeout(Integer idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Bean
	public JettyEmbeddedServletContainerFactory getEmbeddedServletContainerFactory() {
		// InetSocketAddress socketAddress = new InetSocketAddress(address,
		// port);
		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory(
				8888);

		// factory.setAddress(socketAddress.getAddress());
		factory.addServerCustomizers(new JettyServerCustomizer() {
			@Override
			public void customize(final Server server) {
				final QueuedThreadPool threadPool = server
						.getBean(QueuedThreadPool.class);
				threadPool.setName("jetty-");
				threadPool.setMaxThreads((maxThreads));
				threadPool.setMinThreads((minThreads));
				threadPool.setIdleTimeout((idleTimeout));
			}
		});

		return factory;
	}
}
