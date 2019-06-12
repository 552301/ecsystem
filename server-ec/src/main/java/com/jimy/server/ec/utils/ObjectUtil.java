package com.jimy.server.ec.utils;

import org.springframework.beans.BeanUtils;

public class ObjectUtil {

	/**
	 * 拷贝属性，类似 BeanUtils.copyProperties
	 *
	 * @param source-源对象
	 * @param target-目标对象
	 */
	public static void copyProperties(Object source, Object target) {

		BeanUtils.copyProperties(source, target);
	}
}
