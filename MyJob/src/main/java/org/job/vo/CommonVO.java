package org.job.vo;

import com.alibaba.fastjson.JSONObject;

public class CommonVO {
	
	public CommonVO() {
		super();
	}
	@Override
	public String toString() {
		return toJson();
	}
	public String toJson(){
		return JSONObject.toJSONString(this);
	}
	public void println(Object str) {
		System.out.println(str);
	}
	public void print(Object str) {
		System.out.print(str);
	}
}
