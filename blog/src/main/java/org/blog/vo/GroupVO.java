package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-57 10:27:02
 * 
 */ 
public class GroupVO implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String tableName = "pub_group";


    public int group_id;

    public String group_code;

    public String group_name;

    public String group_desc;

    public String ts;

    public Date time_stamp;

    public int temp_int1;

    public int temp_int2;

    public String temp_int3;

    public String temp_var1;

    public String temp_var2;

    public String temp_var3;

    public GroupVO(){

    }

    public int getGroup_id(){
        return group_id;
    }
    public void setGroup_id(int group_id){
        this.group_id =group_id;
    }
    public String getGroup_code(){
        return group_code;
    }
    public void setGroup_code(String group_code){
        this.group_code =group_code;
    }
    public String getGroup_name(){
        return group_name;
    }
    public void setGroup_name(String group_name){
        this.group_name =group_name;
    }
    public String getGroup_desc(){
        return group_desc;
    }
    public void setGroup_desc(String group_desc){
        this.group_desc =group_desc;
    }
    public String getTs(){
        return ts;
    }
    public void setTs(String ts){
        this.ts =ts;
    }
    public Date getTime_stamp(){
        return time_stamp;
    }
    public void setTime_stamp(Date time_stamp){
        this.time_stamp =time_stamp;
    }
    public int getTemp_int1(){
        return temp_int1;
    }
    public void setTemp_int1(int temp_int1){
        this.temp_int1 =temp_int1;
    }
    public int getTemp_int2(){
        return temp_int2;
    }
    public void setTemp_int2(int temp_int2){
        this.temp_int2 =temp_int2;
    }
    public String getTemp_int3(){
        return temp_int3;
    }
    public void setTemp_int3(String temp_int3){
        this.temp_int3 =temp_int3;
    }
    public String getTemp_var1(){
        return temp_var1;
    }
    public void setTemp_var1(String temp_var1){
        this.temp_var1 =temp_var1;
    }
    public String getTemp_var2(){
        return temp_var2;
    }
    public void setTemp_var2(String temp_var2){
        this.temp_var2 =temp_var2;
    }
    public String getTemp_var3(){
        return temp_var3;
    }
    public void setTemp_var3(String temp_var3){
        this.temp_var3 =temp_var3;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}