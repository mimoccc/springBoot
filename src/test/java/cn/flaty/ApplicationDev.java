package cn.flaty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


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
		SpringApplication.run(ApplicationDev.class);
	}

}
