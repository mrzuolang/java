package org.job.entity;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-04-116 09:21:29
 * 
 */ 
public class T2018VO implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final String tableName = "pk10_2018";

    //期数:677919
    public long bill_code;
    //919-921
    public String plan_code;
    //5,6,2,7,10
    public String plan_content;
    //4
    public String num_one;
    //0是不中 1是中
    public String result;
    //开奖时间
    public Date open_time;
    //出现的结果集
    public String nums;
    //1
    public String n1;
    //2
    public String n2;
    //3
    public String n3;
    //4
    public String n4;
    //5
    public String n5;
    //6
    public String n6;
    //7
    public String n7;
    //8
    public String n8;
    //9
    public String n9;
    //10
    public String n10;

    public T2018VO(){

    }

    public long getBill_code(){
        return bill_code;
    }
    public void setBill_code(long bill_code){
        this.bill_code =bill_code;
    }
    public String getPlan_code(){
        return plan_code;
    }
    public void setPlan_code(String plan_code){
        this.plan_code =plan_code;
    }
    public String getPlan_content(){
        return plan_content;
    }
    public void setPlan_content(String plan_content){
        this.plan_content =plan_content;
    }
    public String getNum_one(){
        return num_one;
    }
    public void setNum_one(String num_one){
        this.num_one =num_one;
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result =result;
    }
    public Date getOpen_time(){
        return open_time;
    }
    public void setOpen_time(Date open_time){
        this.open_time =open_time;
    }
    public String getNums(){
        return nums;
    }
    public void setNums(String nums){
        this.nums =nums;
    }
    public String getN1(){
        return n1;
    }
    public void setN1(String n1){
        this.n1 =n1;
    }
    public String getN2(){
        return n2;
    }
    public void setN2(String n2){
        this.n2 =n2;
    }
    public String getN3(){
        return n3;
    }
    public void setN3(String n3){
        this.n3 =n3;
    }
    public String getN4(){
        return n4;
    }
    public void setN4(String n4){
        this.n4 =n4;
    }
    public String getN5(){
        return n5;
    }
    public void setN5(String n5){
        this.n5 =n5;
    }
    public String getN6(){
        return n6;
    }
    public void setN6(String n6){
        this.n6 =n6;
    }
    public String getN7(){
        return n7;
    }
    public void setN7(String n7){
        this.n7 =n7;
    }
    public String getN8(){
        return n8;
    }
    public void setN8(String n8){
        this.n8 =n8;
    }
    public String getN9(){
        return n9;
    }
    public void setN9(String n9){
        this.n9 =n9;
    }
    public String getN10(){
        return n10;
    }
    public void setN10(String n10){
        this.n10 =n10;
    }
    @Override
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}