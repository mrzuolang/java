package org.job.entity;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-04-114 18:51:49
 * 
 */ 
public class JobVO implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String tableName = "jobs";

    //主键
    public long job_id;
    //任务名称
    public String job_name;
    //类名
    public String class_name;
    //任务启动时间
    public Date start_time;
    //任务结束时间
    public Date end_time;
    //结果
    public String result;
    //异常信息
    public String exception_msg;
    //最后修改时间
    public Date update_time;
    //备注
    public String remark;

    public JobVO(){

    }
    
    public long getJob_id() {
		return job_id;
	}

	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public static String getTablename() {
		return tableName;
	}

	public String getClass_name(){
        return class_name;
    }
    public void setClass_name(String class_name){
        this.class_name =class_name;
    }
    public Date getStart_time(){
        return start_time;
    }
    public void setStart_time(Date start_time){
        this.start_time =start_time;
    }
  
    public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result =result;
    }
    public String getException_msg(){
        return exception_msg;
    }
    public void setException_msg(String exception_msg){
        this.exception_msg =exception_msg;
    }
    public Date getUpdate_time(){
        return update_time;
    }
    public void setUpdate_time(Date update_time){
        this.update_time =update_time;
    }
    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark =remark;
    }
    @Override
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}