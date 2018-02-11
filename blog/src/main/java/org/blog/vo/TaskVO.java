package org.blog.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * @作者 lang
 * 生成于：2018-02-42 21:02:55
 * 
 */ 
public class TaskVO implements Serializable{
    private static final long serialVersionUID = 1L;

    //任务主键
    public int task_id;
    //任务名称，唯一
    public String task_name;

    public String class_name;
    //任务开始时间
    public String start_time;
    //任务结果时间
    public String end_time;
    //时间戳
    public String ts;

    public String result;

    public String exception_msg;

    public String tmp_var1;

    public String tmp_var2;

    public String tmp_var3;

    public int tmp_int1;

    public int tmp_int2;

    public int tmp_int3;

    public TaskVO(){

    }

    public int getTask_id(){
        return task_id;
    }
    public void setTask_id(int task_id){
        this.task_id =task_id;
    }
    public String getTask_name(){
        return task_name;
    }
    public void setTask_name(String task_name){
        this.task_name =task_name;
    }
    public String getClass_name(){
        return class_name;
    }
    public void setClass_name(String class_name){
        this.class_name =class_name;
    }
    public String getStart_time(){
        return start_time;
    }
    public void setStart_time(String start_time){
        this.start_time =start_time;
    }
    public String getEnd_time(){
        return end_time;
    }
    public void setEnd_time(String end_time){
        this.end_time =end_time;
    }
    public String getTs(){
        return ts;
    }
    public void setTs(String ts){
        this.ts =ts;
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
    public String getTmp_var1(){
        return tmp_var1;
    }
    public void setTmp_var1(String tmp_var1){
        this.tmp_var1 =tmp_var1;
    }
    public String getTmp_var2(){
        return tmp_var2;
    }
    public void setTmp_var2(String tmp_var2){
        this.tmp_var2 =tmp_var2;
    }
    public String getTmp_var3(){
        return tmp_var3;
    }
    public void setTmp_var3(String tmp_var3){
        this.tmp_var3 =tmp_var3;
    }
    public int getTmp_int1(){
        return tmp_int1;
    }
    public void setTmp_int1(int tmp_int1){
        this.tmp_int1 =tmp_int1;
    }
    public int getTmp_int2(){
        return tmp_int2;
    }
    public void setTmp_int2(int tmp_int2){
        this.tmp_int2 =tmp_int2;
    }
    public int getTmp_int3(){
        return tmp_int3;
    }
    public void setTmp_int3(int tmp_int3){
        this.tmp_int3 =tmp_int3;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}