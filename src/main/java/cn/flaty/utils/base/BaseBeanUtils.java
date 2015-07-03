package cn.flaty.utils.base;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;


public class BaseBeanUtils  {
	
	public static void copyProperties(Object desc,Object orig){
		try {
			PropertyUtils.copyProperties(desc, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
