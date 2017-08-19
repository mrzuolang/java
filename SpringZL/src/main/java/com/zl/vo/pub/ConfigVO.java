package com.zl.vo.pub;
import com.zl.vo.common.CommonVO;
public class ConfigVO extends CommonVO{
    //主键
    public String id;
    //根据key取值
    public String key;
    //配置的值
    public String value;
    //备注
    public String remark;
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id =id;
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

}