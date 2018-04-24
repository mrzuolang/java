package org.job.entity;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-04-114 18:51:49
 * 
 */ 
public class ConfigVO implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String tableName = "sys_config";

    //主键
    public long conf_id;
    //key
    public String conf_key;
    //value
    public String conf_value;
    //备注
    public String remark;
    //最后更新时间
    public Date update_time;
    //修改用户
    public long user_id;

    public ConfigVO(){

    }

    public long getConf_id(){
        return conf_id;
    }
    public void setConf_id(long conf_id){
        this.conf_id =conf_id;
    }
    public String getConf_key(){
        return conf_key;
    }
    public void setConf_key(String conf_key){
        this.conf_key =conf_key;
    }
    public String getConf_value(){
        return conf_value;
    }
    public void setConf_value(String conf_value){
        this.conf_value =conf_value;
    }
    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark =remark;
    }
    public Date getUpdate_time(){
        return update_time;
    }
    public void setUpdate_time(Date update_time){
        this.update_time =update_time;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
        this.user_id =user_id;
    }
    @Override
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}