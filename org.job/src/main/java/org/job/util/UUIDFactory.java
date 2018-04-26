package org.job.util;

import java.util.UUID;

/**
 * @author lang
 * UUID生成类
 */
public class UUIDFactory {
	/**
	 * 随机UUID大写
	 * @return DD71AE88-6425-4E3E-84AE-3387C531942E
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().toUpperCase();
	}
}	
