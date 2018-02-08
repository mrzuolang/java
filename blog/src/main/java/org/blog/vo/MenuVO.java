package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-40
 */ 
public class MenuVO implements Serializable{
    private static final long serialVersionUID = 1L;
    //主键
    public String menu_id;
    //树编码
    public String menu_code;
    //菜单、按钮、节点名称
    public String menu_name;
    //功能菜单的URL
    public String menu_url;
    //类型：1、功能、2、虚拟节点、3、按钮
    public byte menu_type;
    //是否禁用：0、禁用；1、是启用
    public byte menu_disable;
    //样式
    public String menu_css;
    //
    public String menu_desc;
    //
    public String ts;
    //时间戳
    public Date time_stamp;
    //
    public int temp_int1;
    //
    public int temp_int2;
    //
    public int temp_int3;
    //
    public String temp_var1;
    //
    public String temp_var2;
    //
    public String temp_var3;
    public String getMenu_id(){
        return menu_id;
    }
    public void setMenu_id(String menu_id){
        this.menu_id =menu_id;
    }
    public String getMenu_code(){
        return menu_code;
    }
    public void setMenu_code(String menu_code){
        this.menu_code =menu_code;
    }
    public String getMenu_name(){
        return menu_name;
    }
    public void setMenu_name(String menu_name){
        this.menu_name =menu_name;
    }
    public String getMenu_url(){
        return menu_url;
    }
    public void setMenu_url(String menu_url){
        this.menu_url =menu_url;
    }
    public byte getMenu_type(){
        return menu_type;
    }
    public void setMenu_type(byte menu_type){
        this.menu_type =menu_type;
    }
    public byte getMenu_disable(){
        return menu_disable;
    }
    public void setMenu_disable(byte menu_disable){
        this.menu_disable =menu_disable;
    }
    public String getMenu_css(){
        return menu_css;
    }
    public void setMenu_css(String menu_css){
        this.menu_css =menu_css;
    }
    public String getMenu_desc(){
        return menu_desc;
    }
    public void setMenu_desc(String menu_desc){
        this.menu_desc =menu_desc;
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
    public int getTemp_int3(){
        return temp_int3;
    }
    public void setTemp_int3(int temp_int3){
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