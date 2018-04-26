package org.job.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.job.util.StringUtil;
import org.job.entity.JobVO;

/**
 * @作者 lang 生成于：2018-04-116 09:25:25
 * 
 */
@Mapper
public interface JobDao {
	@Delete("delete from job where job.job_id=#{pk}")
	public int deleteByPk(@Param("pk") int pk);

	@Select("select * from job where job_id =#{pk}")
	public JobVO findByPk(@Param("pk") int pk);

	@Select("select * from job where job_name =#{jobName}")
	public JobVO findByName(@Param("jobName") String jobName);

	@Insert("insert into job (job_id,job_name,class_name,start_time,end_time,result,exception_msg)\n"
			+ " values \n"
			+ "(#{jobVO.job_id},#{jobVO.job_name},#{jobVO.class_name},#{jobVO.start_time},#{jobVO.end_time},#{jobVO.result},#{jobVO.exception_msg})")
	public int insert(@Param("jobVO") JobVO jobVO);

	@UpdateProvider(type = UserDaoProvider.class, method = "updateTaskEnd")
	public int updateTaskEnd(@Param("jobVO") JobVO jobVO);

	class UserDaoProvider {
		public String updateTaskEnd(@Param("jobVO") JobVO jobVO) {
			StringBuilder sql = new StringBuilder("update job set end_time=#{jobVO.end_time},result=#{jobVO.result} ");
			if (StringUtil.isEmpty(jobVO.getException_msg())) {
				sql.append(",exception_msg=#{jobVO.exception_msg}");
			}
			sql.append(" where ");
			if (jobVO.getJob_id() > 0) {
				sql.append(" job_id=#{jobVO.job_id}");
			} else if (!StringUtil.isEmpty(jobVO.getJob_name())) {
				sql.append(" job_name=#{jobVO.job_name}");
			}
			return sql.toString();
		}
	}
}