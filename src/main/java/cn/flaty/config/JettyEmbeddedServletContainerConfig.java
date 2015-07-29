package cn.flaty.config;

import java.net.InetSocketAddress;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyEmbeddedServletContainerConfig {
	@Value("${jetty.server.maxThreads:20}")
	private Integer maxThreads;
	@Value("${jetty.server.minThreads:10}")
	private Integer minThreads;
	@Value("${jetty.server.idleTimeout:60000}")
	private Integer idleTimeout;
	@Value("${server.address:0.0.0.0}")
	private String address;
	@Value("${server.context-path:}")
	private String contextPath;
	@Value("${server.port:8080}")
	private Integer port;

	@Bean
	public JettyEmbeddedServletContainerFactory getEmbeddedServletContainerFactory() {
		InetSocketAddress socketAddress = new InetSocketAddress(address, port);
		JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory(
				this.contextPath, port);

		factory.setAddress(socketAddress.getAddress());
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
