package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-58 17:35:21
 * 
 */ 
public class User_GroupVO implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String tableName = "pub_user_group";

    //用户、组的中间表
    public int user_group_id;

    public int user_id;

    public int group_id;

    public Date time_stamp;

    public User_GroupVO(){

    }

    public int getUser_group_id(){
        return user_group_id;
    }
    public void setUser_group_id(int user_group_id){
        this.user_group_id =user_group_id;
    }
    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id =user_id;
    }
    public int getGroup_id(){
        return group_id;
    }
    public void setGroup_id(int group_id){
        this.group_id =group_id;
    }
    public Date getTime_stamp(){
        return time_stamp;
    }
    public void setTime_stamp(Date time_stamp){
        this.time_stamp =time_stamp;
    }
    @Override
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}