package cn.flaty.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.flaty.config.properties.TomcatPoolDataDevSourceProperties;
import cn.flaty.config.properties.TomcatPoolDataSourceProperties;
import cn.flaty.model.User;
import cn.flaty.persitance.UserMapper;


@RestController
@RequestMapping("/users")
public class UserController  {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TomcatPoolDataSourceProperties config;

	
	@RequestMapping("/index")
	public List<User> home(){
		System.out.println(config.getDriverClassName());
		return userMapper.queryAll();
	}

}
