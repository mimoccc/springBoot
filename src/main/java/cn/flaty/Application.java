package cn.flaty;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 
 * springboot production 启动<Br>
 * 
 * 配置见 config目录
 * 
 * @author chenxingwang
 * 
 */
@SpringBootApplication
@EnableConfigurationProperties
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
	
	
	public static final String PRODUCTION = "production";
	public static final  String DEV = "dev";
	public static final String TEST = "test";

	public static void main(String args[]) throws Exception {
		SpringApplicationBuilder sbb = new SpringApplicationBuilder(Application.class);
		
		sbb.build().run(args);
	}

}
