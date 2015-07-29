package cn.flaty;

import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * springboot production/test 启动<Br>
 * 
 * 开发环境不要启动<Br>
 * 
 * 配置见 config目录<Br>
 * 
 * @author chenxingwang
 * 
 */
@SpringBootApplication
@EnableConfigurationProperties
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
	

	public static void main(String args[]) throws Exception {
		SpringApplicationBuilder sbb = new SpringApplicationBuilder(Application.class);

		// load if test exist
		Properties testProperty = PropertiesLoaderUtils
				.loadAllProperties("application_test.properties");
		if (testProperty != null) {
			sbb.properties(testProperty);
		}
		sbb.build().run(args);
	}

}
