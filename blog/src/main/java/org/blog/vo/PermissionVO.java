package org.blog.vo;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-40
 */ 
public class PermissionVO implements Serializable{
    private static final long serialVersionUID = 1L;
    //
    public String permission_id;
    //
    public String group_id;
    //
    public String user_id;
    //
    public String menu_id;
    public String getPermission_id(){
        return permission_id;
    }
    public void setPermission_id(String permission_id){
        this.permission_id =permission_id;
    }
    public String getGroup_id(){
        return group_id;
    }
    public void setGroup_id(String group_id){
        this.group_id =group_id;
    }
    public String getUser_id(){
        return user_id;
    }
    public void setUser_id(String user_id){
        this.user_id =user_id;
    }
    public String getMenu_id(){
        return menu_id;
    }
    public void setMenu_id(String menu_id){
        this.menu_id =menu_id;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}