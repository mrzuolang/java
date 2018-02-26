package org.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.blog.vo.TaskhistoryVO;

/**
 * @作者 lang
 * 生成于：2018-02-57 10:00:46
 * 
 */ 
@Mapper
public interface TaskhistoryDao{

    /**
     * @param pk
     * @return
     */
    @Delete("delete from timer_taskhistory where timer_taskhistory.task_id=#{pk}")
    public int deleteByPk(@Param("pk")int pk);

    @Select("select * from timer_taskhistory where task_id =#{pk}")
    public TaskhistoryVO findByPk(@Param("pk")int pk);

    @Insert("insert into timer_taskhistory \n"+
        "(task_id,task_name,class_name,start_time,end_time,ts,result,exception_msg,tmp_var1,tmp_var2,tmp_var3,tmp_int1,tmp_int2,tmp_int3)\n" +
        " values \n" +
        "(#{taskhistoryVO.task_id},#{taskhistoryVO.task_name},#{taskhistoryVO.class_name},#{taskhistoryVO.start_time},#{taskhistoryVO.end_time},#{taskhistoryVO.ts},#{taskhistoryVO.result},#{taskhistoryVO.exception_msg},#{taskhistoryVO.tmp_var1},#{taskhistoryVO.tmp_var2},#{taskhistoryVO.tmp_var3},#{taskhistoryVO.tmp_int1},#{taskhistoryVO.tmp_int2},#{taskhistoryVO.tmp_int3})")
    public int insert(@Param("taskhistoryVO") TaskhistoryVO taskhistoryVO);

}