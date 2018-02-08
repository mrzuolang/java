package org.blog.vo;

import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;

/**
 * @作者 lang
 * 生成于：2018-02-39
 */ 
public class UserVO implements Serializable{
    private static final long serialVersionUID = 1L;
    //用户id
    public String user_id;
    //用户名称
    public String user_name;
    //密码
    public String password;
    //编码
    public String bill_code;
    //尼称
    public String nick_name;
    //邮箱
    public String mail;
    //手机号
    public String phone;
    //生日 
    public Date birthday;
    //性别
    public String sex;
    //头像
    public String pic_head;
    //时间戳
    public String ts;
    //
    public Date time_stamp;
    //
    public int tmp_int1;
    //
    public int tmp_int2;
    //
    public int tmp_int3;
    //
    public int tmp_int4;
    //
    public String tmp_var1;
    //
    public String tmp_var2;
    //
    public String tmp_var3;
    //
    public String tmp_var4;
    public String getUser_id(){
        return user_id;
    }
    public void setUser_id(String user_id){
        this.user_id =user_id;
    }
    public String getUser_name(){
        return user_name;
    }
    public void setUser_name(String user_name){
        this.user_name =user_name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password =password;
    }
    public String getBill_code(){
        return bill_code;
    }
    public void setBill_code(String bill_code){
        this.bill_code =bill_code;
    }
    public String getNick_name(){
        return nick_name;
    }
    public void setNick_name(String nick_name){
        this.nick_name =nick_name;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail =mail;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone =phone;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday =birthday;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex =sex;
    }
    public String getPic_head(){
        return pic_head;
    }
    public void setPic_head(String pic_head){
        this.pic_head =pic_head;
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
    public int getTmp_int4(){
        return tmp_int4;
    }
    public void setTmp_int4(int tmp_int4){
        this.tmp_int4 =tmp_int4;
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
    public String getTmp_var4(){
        return tmp_var4;
    }
    public void setTmp_var4(String tmp_var4){
        this.tmp_var4 =tmp_var4;
    }
    public String toString(){
	 return JSONObject.toJSONString(this);
    }
}