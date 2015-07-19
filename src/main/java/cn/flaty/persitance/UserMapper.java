package cn.flaty.persitance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.flaty.model.User;



public interface UserMapper {
	
//	@Select("select name,pwd from user;")
	List<User> queryAll();
}
