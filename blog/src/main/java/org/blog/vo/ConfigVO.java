package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-40
 */ 
public class ConfigVO implements Serializable{
    private static final long serialVersionUID = 1L;
    //主键
    public String config_id;
    //根据key取值
    public String key;
    //配置的值
    public String value;
    //备注
    public String remark;
    //
    public String ts;
    //
    public Date timestamp;
    public String getConfig_id(){
        return config_id;
    }
    public void setConfig_id(String config_id){
        this.config_id =config_id;
    }
    public String getKey(){
        return key;
    }
    public void setKey(String key){
        this.key =key;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value =value;
    }
    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark =remark;
    }
    public String getTs(){
        return ts;
    }
    public void setTs(String ts){
        this.ts =ts;
    }
    public Date getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(Date timestamp){
        this.timestamp =timestamp;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}