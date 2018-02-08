package org.blog.vo;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-40
 */ 
public class User_groupVO implements Serializable{
    private static final long serialVersionUID = 1L;
    //
    public String user_group_id;
    //
    public String user_id;
    //
    public String group_id;
    public String getUser_group_id(){
        return user_group_id;
    }
    public void setUser_group_id(String user_group_id){
        this.user_group_id =user_group_id;
    }
    public String getUser_id(){
        return user_id;
    }
    public void setUser_id(String user_id){
        this.user_id =user_id;
    }
    public String getGroup_id(){
        return group_id;
    }
    public void setGroup_id(String group_id){
        this.group_id =group_id;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}