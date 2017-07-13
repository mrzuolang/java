package test.mysql.table;

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
}
