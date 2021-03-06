package cn.flaty.web.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.flaty.model.User;
import cn.flaty.persitance.UserMapper;


@RestController
@RequestMapping("/users")
public class UserController  {
	
	@Resource
	private UserMapper userMapper;
	

	
	@RequestMapping("/index")
	public List<User> home(){
		return userMapper.queryAll();
	}

}
