package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-40 11:02:27
 * 
 */ 
public class PermissionVO implements Serializable{
    private static final long serialVersionUID = 1L;


    public int permission_id;

    public int group_id;

    public int user_id;

    public int menu_id;

    public Date time_stamp;

    public PermissionVO(){

    }

    public int getPermission_id(){
        return permission_id;
    }
    public void setPermission_id(int permission_id){
        this.permission_id =permission_id;
    }
    public int getGroup_id(){
        return group_id;
    }
    public void setGroup_id(int group_id){
        this.group_id =group_id;
    }
    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id =user_id;
    }
    public int getMenu_id(){
        return menu_id;
    }
    public void setMenu_id(int menu_id){
        this.menu_id =menu_id;
    }
    public Date getTime_stamp(){
        return time_stamp;
    }
    public void setTime_stamp(Date time_stamp){
        this.time_stamp =time_stamp;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}