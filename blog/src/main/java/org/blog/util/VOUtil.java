package org.blog.util;

import org.blog.vo.TaskVO;
import org.blog.vo.TaskhistoryVO;

public class VOUtil {
	public static TaskhistoryVO getTaskVO(TaskVO taskVO) {
		TaskhistoryVO historyVO = new TaskhistoryVO();
		if(taskVO==null)return historyVO;
		historyVO.setTask_id(taskVO.getTask_id());
		historyVO.setTask_name(taskVO.getTask_name());
		historyVO.setClass_name(taskVO.getClass_name());
		historyVO.setStart_time(taskVO.getStart_time());
		historyVO.setEnd_time(taskVO.getEnd_time());
		historyVO.setResult(taskVO.getResult());
		historyVO.setException_msg(taskVO.getException_msg());
		historyVO.setTs(taskVO.getTs());
		historyVO.setTmp_int1(taskVO.getTmp_int1());
		historyVO.setTmp_int2(taskVO.getTmp_int2());
		historyVO.setTmp_int3(taskVO.getTmp_int3());
		historyVO.setTmp_var1(taskVO.getTmp_var1());
		historyVO.setTmp_var2(taskVO.getTmp_var2());
		historyVO.setTmp_var3(taskVO.getTmp_var3());

		return historyVO;
	}
}
