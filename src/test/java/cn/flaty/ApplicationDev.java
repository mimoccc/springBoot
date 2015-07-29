package cn.flaty;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * 开发环境启动<Br>
 * 
 * 配置见 config目录
 * 
 * @author chenxingwang
 * 
 */
@SpringBootApplication
@EnableConfigurationProperties
public class ApplicationDev {

	public static void main(String args[]) throws Exception {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(
				ApplicationDev.class);

		// 手动加载dev环境
		builder.properties(
				PropertiesLoaderUtils
						.loadAllProperties("application_dev.properties"))
				.build().run(args);
	}

}
