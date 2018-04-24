package org.job.util;

import java.util.UUID;

public class UUIDS {
	public static String getID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String getID(String name) {
		return UUID.fromString(name).toString().replaceAll("-", "");
	}
}
