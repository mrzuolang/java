package org.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.blog.vo.TaskVO;

/**
 * @作者 lang
 * 生成于：2018-02-42 23:50:54
 * 
 */ 
@Mapper
public interface TaskDao{

    @Delete("delete from timer_task where timer_task.task_id=#{pk}")
    public int deleteByPk(@Param("pk")int pk);

    @Select("select * from timer_task where task_id =#{pk}")
    public TaskVO findByPk(@Param("pk")int pk);

    @Insert("insert into timer_task \n"+
        "(task_id,task_name,class_name,start_time,end_time,ts,result,exception_msg,tmp_var1,tmp_var2,tmp_var3,tmp_int1,tmp_int2,tmp_int3)\n" +
        " values \n" +
        "(#{taskVO.task_id},#{taskVO.task_name},#{taskVO.class_name},#{taskVO.start_time},#{taskVO.end_time},#{taskVO.ts},#{taskVO.result},#{taskVO.exception_msg},#{taskVO.tmp_var1},#{taskVO.tmp_var2},#{taskVO.tmp_var3},#{taskVO.tmp_int1},#{taskVO.tmp_int2},#{taskVO.tmp_int3})")
    public int insert(@Param("taskVO") TaskVO taskVO);

}