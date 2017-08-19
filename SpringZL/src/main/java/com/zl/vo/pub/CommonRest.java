package com.zl.vo.pub;

import com.zl.vo.common.CommonVO;

public class CommonRest {

	static class RespnseObject extends CommonVO {
		String code;// 代码 200
		String msg;// 返回内容
		String error;// 错误明细

		public RespnseObject() {
			super();
		}

		public RespnseObject(Exception e) {
			super();
			this.code = "500";
			this.msg = "系统异常";
			this.error = e.getMessage();
		}
		public RespnseObject(String error) {
			super();
			this.code = "500";
			this.msg = error;
			this.error = error;
		}
		
	}

	public String Exception(Exception e) {
		return new RespnseObject(e).toJson();
	}
	public String Exception(String erroe) {
		return new RespnseObject(erroe).toJson();
	}
}
